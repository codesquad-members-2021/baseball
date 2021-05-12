import { useContext } from 'react';
import styled from "styled-components";
import { GlobalContext } from "util/context.js";
import { GlobalAction } from 'util/action.js';

function GameListItem({ match, idx, isLoading }) {
  const { globalDispatch } = useContext(GlobalContext);

  const handleClickTeam = ({ playTeam, home }) => {
    globalDispatch({
        type: GlobalAction.SELECT_TEAM,
        payload: { gameId: match.id, playTeam, home }
    });
  }

  return (
    isLoading
    ? <StlyedLoadingListItem/>
    : <StyledGameListItem>
        <GameNumber>Game {idx + 1}</GameNumber>
        <MatchInformation>
            <TeamAway onClick={() => handleClickTeam({
              playTeam: match.away.name,
              home: false
            })}>
              {match.away.name}
            </TeamAway>
            <div className="versus">vs.</div>
            <TeamHome onClick={() => handleClickTeam({
              playTeam: match.home.name,
              home: true
            })}>
              {match.home.name}
            </TeamHome>
        </MatchInformation>
    </StyledGameListItem>
  );
}

export default GameListItem;

const StyledGameListItem = styled.li`
  color: black;
  list-style: none;
  text-align: center;
  background-color: #b3b3b3;
  border-radius: 10px;
  height: 5rem;
  font-weight: 600;
  padding: 0.5rem;

    & + & {
        margin-top: 1rem;
    }
`;

const GameNumber = styled.div`
  color: red;
`;

const MatchInformation = styled.div`
  & > div {
    display: inline-block;
    font-size: 1.8rem;
    width: calc(100% / 3);
    &:hover {
      cursor: pointer;
      color: red;
      transition: 0.3s;
    }
  }
  .versus {
    width: 30%;
    font-size: 1.5rem;
    &:hover {
      color: unset;
      cursor: unset;
    }
  }
`;

const TeamHome = styled.div`
  text-align: left;
`;

const TeamAway = styled.div`
  text-align: right;
`;

const StlyedLoadingListItem = styled.li`
  list-style: none;
  text-align: center;
  background-color: #b3b3b3;
  border-radius: 10px;
  height: 5rem;
  padding: 0.5rem;

    & + & {
        margin-top: 1rem;
    }
`
