import LogRowNumber from "./LogRowNumber";
import LogRowAction from "./LogRowAction";
import LogRowBallCount from "./LogRowBallCount";
import { GamePlayLog as S } from "@/Components/Game/GameStyles";

const Log = () => {
  return (
    <S.PlayerLog.LogRow>
      <LogRowNumber />
      <LogRowAction />
      <LogRowBallCount />
    </S.PlayerLog.LogRow>
  );
};

export default Log;
