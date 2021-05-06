import LogRow from "./LogRow/LogRow";
import { GamePlayLog as S } from "@/Components/Game/GameStyles";

const Log = () => {
  return (
    <S.PlayerLog.Log>
      <LogRow />
      <LogRow />
      <LogRow />
      <LogRow />
      <LogRow />
    </S.PlayerLog.Log>
  );
};

export default Log;
