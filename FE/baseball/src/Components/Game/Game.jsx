import GameHeader from "./GameHeader/GameHeader";
import GamePlayground from "./GamePlayground/GamePlayground";
import GamePlayLog from "./GamePlayLog/GamePlayLog";
import SquadBoard from "./SquadBoard/SquadBoard";
import ScoreBoard from "./ScoreBoard/ScoreBoard";
import { Game as S } from "@/Components/Game/GameStyles";

const Game = () => {
  const backgroundUrl =
    "https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png";
  return (
    <>
      <S.Background src={backgroundUrl} />
      <S.Game>
        <S.GameLeftSection>
          <ScoreBoard />
          <GameHeader />
          <GamePlayground />
        </S.GameLeftSection>
        <S.GameRightSection>
          <GamePlayLog />
        </S.GameRightSection>
        <SquadBoard />
      </S.Game>
    </>
  );
};

export { Game };
