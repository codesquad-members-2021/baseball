import LogBox from "./LogBox";
import { GamePlayLog as S } from "@/Components/Game/GameStyles";

const PlayerLog = () => {
  return (
    <S.PlayerLog.PlayerLog>
      <LogBox />
      <LogBox />
      <LogBox />
      <LogBox />
    </S.PlayerLog.PlayerLog>
  );
};

export default PlayerLog;
