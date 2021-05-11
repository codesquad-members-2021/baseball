import { createContext, useState, useEffect } from "react";
import GameHeader from "./GameHeader/GameHeader";
import GamePlayground from "./GamePlayground/GamePlayground";
import GamePlayLog from "./GamePlayLog/GamePlayLog";
import SquadBoard from "./SquadBoard/SquadBoard";
import ScoreBoard from "./ScoreBoard/ScoreBoard";
import { squadMockData } from "@/Utils/mockData";
import { BACKGROUND_URL } from "@/Utils/const";
import { getAPI } from "@/Utils/API";
import { Game as S } from "@/Components/Game/GameStyles";

const GameContext = createContext();

const Game = ({
  location: {
    state: { gameId, teamName },
  },
}) => {
  // 선택한 팀을 먼저 수비로 지정한다.
  // 추후 아웃 3카운트 이후 데이터를 받아올때 defenseTeam을 바꿔줄 예정
  squadMockData.defenseTeam = teamName;

  const [gameData, setGameData] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    getAPI
      .game(gameId)
      .then((res) => {
        if (res && res.data) setGameData(res.data);
        else throw Error();
      })
      .catch((err) => setError(err));
  }, [gameId]);

  if (error || !gameData) return null;

  return (
    <GameContext.Provider value={{ gameData, squadMockData, teamName }}>
      <S.Background src={BACKGROUND_URL} />
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
