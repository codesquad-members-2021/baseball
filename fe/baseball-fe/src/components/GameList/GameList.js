import { useRef, useState, useEffect, useContext } from "react";
import { GlobalContext } from "util/context.js";
import styled from "styled-components";
import GameListItem from "./GameListItem";
import useFetch from 'util/hook/useFetch';
import API from 'util/API';

function GameList({ setMessage }) {
  const { globalState } = useContext(GlobalContext);
  const [scrollWidth, setScrollWidth] = useState();
  const [mouseOver, setMouseOver] = useState(false);
  const [gameList, setGameList] = useState();
  const { response , error, isLoading } = useFetch(API.games());
  const ref = useRef();

  useEffect(() => {
    if (!response)
      return;

    setGameList(response);
  }, [response]);

  useEffect(() => {
    if (!error)
      return;

    console.error(error);
  }, [error]);

  useEffect(() => {
    if (mouseOver === false || scrollWidth)
      return;

    setScrollWidth(ref.current.offsetWidth - ref.current.clientWidth);
  }, [mouseOver]);

  const handleMouseOver = () => {
    setMouseOver(true);
  }

  const handleMouseEnter = () => {
    setMouseOver(true);
  }

  const handleMouseLeave = () => {
    setMouseOver(false);
  }

  return (
    <StyledGameList
      ref={ref}
      mouseOver={mouseOver}
      scrollWidth={mouseOver ? scrollWidth : 0}
      onMouseOverCapture={handleMouseOver}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}>
      {gameList &&
        gameList.map((match, idx) => (
          <GameListItem key={idx} match={match} idx={idx} isLoading={isLoading} setMessage={setMessage}/>
        ))}
    </StyledGameList>
  );
}

export default GameList;

const StyledGameList = styled.ul`
  & > * {
    font-size: 1.4rem;
  }
  width: calc(500px + ${props => String(props.scrollWidth) + 'px'});
  height: 20rem;
  margin-left: ${props => String(props.scrollWidth) + 'px'};
  padding: 0;
  overflow-y: ${props => props.mouseOver ? 'scroll' : 'hidden'};
`;

