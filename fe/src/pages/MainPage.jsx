import styled from "styled-components";

import PlaySection from "../components/PlaySection/PlaySection";

import CurrentPlayer from "../components/CurrentPlayerSection/CurrentPlayer.js";
import ScoreBoard from '../components/ScoreBoard/ScoreBoard.jsx'
import HistoryList from "../components/HistorySection/HistoryList.js";

const MainPage = () => {
  return (
    <MainPageLayout>
      <ScoreBoard className={"grid-area__Score"} />
      <CurrentPlayer className={"grid-area__CurrentPlayer"} />
      
      <div className={"grid-area__Play"}>
        <PlaySection></PlaySection>
      </div>
      <HistoryList className={"grid-area__History"} />
    </MainPageLayout>
  );
};

const MainPageLayout = styled.div`
  display: grid;
  grid-template-rows: repeat(4, 25vh);
  grid-template-columns: repeat(4, 1fr);
  grid-template-areas:
    "Score Score Score CurrentPlayer"
    "Play Play Play History"
    "Play Play Play History"
    "Play Play Play History";

  .grid-area__Score {
    grid-area: Score;
    background-color: #fcb4b4;
  }
  .grid-area__CurrentPlayer {
    grid-area: CurrentPlayer;
    background-color: #859096;
  }
  .grid-area__Play {
    position: relative;
    grid-area: Play;
  }
  .grid-area__History {
    grid-area: History;
    background-color: #a4a5a7;
  }
`;
export default MainPage;
