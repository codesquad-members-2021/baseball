import React, { useContext } from "react";
import GameHeader from "./GameHeader/GameHeader";
import GamePlayground from "./GamePlayground/GamePlayground";
import GamePlayLog from "./GamePlayLog/GamePlayLog";
import SquadBoard from "./SquadBoard/SquadBoard";
import ScoreBoard from "./ScoreBoard/ScoreBoard";
import { squadMockData } from "@/Utils/mockData";
import { Game as S } from "@/Components/Game/GameStyles";
import { RouterContext } from "@/Routes/Router";

const GameContext = React.createContext();

const Game = () => {
  const { gameData, selectedTeam } = useContext(RouterContext);

  const backgroundUrl =
    "https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png";

  // 선택한 팀을 먼저 수비로 지정한다.
  // 추후 아웃 3카운트 이후 데이터를 받아올때 defenseTeam을 바꿔줄 예정
  squadMockData.defenseTeam = selectedTeam;

  return (
    <GameContext.Provider value={{ gameData, squadMockData, selectedTeam }}>
      <S.Background src={backgroundUrl} />
      <S.Game>
        <S.GameLeftSection>
          <GameHeader />
          <GamePlayground />
        </S.GameLeftSection>
        <S.GameRightSection>
          <GamePlayLog />
        </S.GameRightSection>
        <ScoreBoard />
        <SquadBoard />
      </S.Game>
    </GameContext.Provider>
  );
};

export { Game, GameContext };
