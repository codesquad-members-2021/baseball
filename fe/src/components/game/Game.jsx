import styled from "styled-components";
import Title from "../shared/Title";
import CurrentIningInfo from "./baseballField/CurrentIningInfo";
import Diamond from "./baseballField/Diamond";
import PitchButton from "./baseballField/PitchButton";
import SBO from "./baseballField/SBO";
import CurrentPlayer from "./CurrentPlayer";
import DetailScorePopup from "./DetailScorePopup";
import PlayerHistory from "./PlayerHistory";
import PlayerListPopup from "./PlayerListPopup";
import TeamScore from "./TeamScore";

const Game = () => {
  return (
    <>
      <GameContainer>
        <GameProgress>
          {/* style-component*/}
          <MainScoreBoard>
            {/* style-component*/}
            <Title />
            <ScoreBox>
              <TeamScore isHome={false} />
              <span>VS</span>
              <TeamScore isHome />
            </ScoreBox>
          </MainScoreBoard>
          <BaseballField>
            {/* style-component*/}
            <SBO />
            <Diamond>
              <PitchButton />
            </Diamond>
            <CurrentIningInfo />
          </BaseballField>
        </GameProgress>

        <PlayerProgress>
          {/* style-component*/}
          <CurrentPlayerContainer>
            {/* style-component*/}
            <CurrentPlayer />
            <CurrentPlayer />
          </CurrentPlayerContainer>
          <PlayerHistoryContainer>
            {/* style-component*/}
            <PlayerHistory />
            <PlayerHistory />
            <PlayerHistory />
            {/*map 돌릴 예정 */}
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
