import CurrentPlayer from "./CurrentPlayer/CurrentPlayer";
import PlayerLog from "./PlayerLog/PlayerLog";
import { GamePlayLog as S } from "@/Components/Game/GameStyles";

const GamePlayLog = () => {
  return (
    <S.GamePlayLog>
      <CurrentPlayer />
      <PlayerLog />
    </S.GamePlayLog>
  );
};

export default GamePlayLog;
