import GameHeader from "./GameHeader/GameHeader";
import GamePlayground from "./GamePlayground/GamePlayground";
import GamePlayLog from "./GamePlayLog/GamePlayLog";
import SquadBoard from "./SquadBoard/SquadBoard";
import { Game as S } from "@/Components/Game/GameStyles";

const Game = () => {
  return (
    <S.Game>
      <S.GameLeftSection>
        <GameHeader />
        <GamePlayground />
      </S.GameLeftSection>
      <S.GameRightSection>
        <GamePlayLog />
      </S.GameRightSection>
      <SquadBoard />
    </S.Game>
  );
};

export { Game };
