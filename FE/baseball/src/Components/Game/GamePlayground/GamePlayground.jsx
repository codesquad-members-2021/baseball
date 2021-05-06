import InningInfo from "./InningInfo";
import PitchButton from "./PitchButton";
import GameDisplay from "./GameDisplay/GameDisplay";
import BallCountBoard from "./BallCountBoard/BallCountBoard";
import { GamePlayground as S } from "@/Components/Game/GameStyles";

const GamePlayground = () => {
  const backgroundUrl =
    "https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png";
  return (
    <S.GamePlayground>
      <S.Background src={backgroundUrl} />
      <BallCountBoard />
      <InningInfo inningInfo={"2회초 수비"} />
      <GameDisplay />
      <PitchButton />
    </S.GamePlayground>
  );
};

export default GamePlayground;
