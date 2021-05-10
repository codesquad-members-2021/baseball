import { useContext, useState } from "react";
import styled from "styled-components";
import ScoreBoard from "./ScoreBoard/ScoreBoard";
import LineUp from "./LineUp/LineUp";
import Ground from "./Ground/Ground";
import Record from "./Record/Record";
import { LoginContext } from "../Home/Home";

const InGame = () => {
  const [slideScoreBoard, toggleScoreBoard] = useState(false);
  const [slideLineUp, toggleLineUp] = useState(false);
  const [isDark, setDark] = useState(false);
  const { loginStatus } = useContext(LoginContext);
  const clickMain = () => {
    toggleScoreBoard(false);
    toggleLineUp(false);
    setDark(false);
  };
  console.log(loginStatus);
  return (
    // loginStatus true 일때만 아래 렌더링
    <>
      {loginStatus ? (
        <StyledInGame>
          <ScoreBoard
            slide={slideScoreBoard}
            toggle={toggleScoreBoard}
            isDark={isDark}
            setDark={setDark}
          />
          <LineUp
            slide={slideLineUp}
            toggle={toggleLineUp}
            isDark={isDark}
            setDark={setDark}
          />
          <Main onClick={clickMain} isDark={isDark}>
            <Ground />
            <Record />
          </Main>
        </StyledInGame>
      ) : (
        <WrongApproach>잘못된 접근입니다.</WrongApproach>
      )}
    </>
  );
};

export default InGame;

const StyledInGame = styled.div`
  position: relative;
  overflow: hidden;
  margin-top: 30px;
`;
const Main = styled.div`
  height: 720px;
  filter: ${({ isDark }) => (isDark ? "brightness(20%)" : "")};
  transition: filter 400ms;

  font-size: 5rem;
  color: white;
`;

const WrongApproach = styled.div`
  color: white;
`;
