import { useContext, useEffect, useState } from "react";
import styled from "styled-components";
import { GlobalContext } from "../../App";
import Title from "../shared/Title";
import CurrentInningInfo from "./baseballField/CurrentInningInfo";
import Diamond from "./baseballField/Diamond";
import PitchButton from "./baseballField/PitchButton";
import SBO from "./baseballField/SBO";
import CurrentPlayer from "./CurrentPlayer";
import DetailScorePopup from "./DetailScorePopup";
import PlayerHistory from "./PlayerHistory";
import PlayerListPopup from "./PlayerListPopup";
import TeamScore from "./TeamScore";

const Game = () => {
  const { myTeam, counterTeam, homeTeam, currGameState } = useContext(GlobalContext);
  const expeditionTeam = homeTeam.id !== myTeam.id ? myTeam : counterTeam;
  // useEffect(() => {
  //   fetch("/api/")
  //     .then((res) => res.json())
  //     .then((res) => console.log(res));
  // }, [homeTeam]);

  // const homeTeam = counterTeam.home ? counterTeam : myTeam; // counterTeam이 홈팀이야?
  // const expeditionTeam = !counterTeam.home ? counterTeam : myTeam; // counterTeam이 원정팀이야?

  return (
    <>
      <GameContainer>
        <GameProgress>
          {/* style-component*/}
          <MainScoreBoard>
            {/* style-component*/}
            <Title />
            <ScoreBox>
              <TeamScore isHome={false} team={expeditionTeam} score={currGameState.expeditionTeam.totalScore} />
              <span>VS</span>
              <TeamScore isHome team={homeTeam} score={currGameState.homeTeam.totalScore} />
            </ScoreBox>
          </MainScoreBoard>
          <BaseballField>
            {/* style-component*/}
            <SBO />
            <Diamond>
              <PitchButton />
            </Diamond>
            <CurrentInningInfo inning={currGameState.inning} />
          </BaseballField>
        </GameProgress>

        <PlayerProgress>
          {/* style-component*/}
          <CurrentPlayerContainer>
            {/* style-component*/}
            <CurrentPlayer player={currGameState.pitcher} />
            <CurrentPlayer player={currGameState.hitter} />
          </CurrentPlayerContainer>
          <PlayerHistoryContainer>
            {/* style-component*/}
            {currGameState.teamLog.playerLog.length &&
              [...currGameState.teamLog.playerLog].map((playerHistory) => <PlayerHistory history={playerHistory} />)}
          </PlayerHistoryContainer>
        </PlayerProgress>
      </GameContainer>
      <DetailScorePopup />
      <PlayerListPopup />
    </>
  );
};

export default Game;

const GameContainer = styled.section`
  display: flex;
  width: 1200px;
  border: 1px solid red;
  & div {
    border: 1px solid black;
  }
`;

const GameProgress = styled.div`
  display: flex;
  width: 80%;
  flex-direction: column;
`;

const ScoreBox = styled.div`
  display: flex;
`;

const MainScoreBoard = styled.div`
  height: 200px;
  // width: 80%;
`;
const BaseballField = styled.div`
  // width: 80%;
  height: 700px;
  display: flex;
  justify-content: space-between;
`;

const PlayerProgress = styled.div`
  display: flex;
  flex-direction: column;
  width: 20%;
`;
const CurrentPlayerContainer = styled.div`
  height: 200px;
  // width: 20%;
`;
const PlayerHistoryContainer = styled.div`
  // width: 20%;
  height: 700px;
`;
