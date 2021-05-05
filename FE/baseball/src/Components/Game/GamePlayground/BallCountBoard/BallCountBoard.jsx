import BallJudgement from "./BallJudgement";
import BallCount from "./BallCount";
import { GamePlayground as S } from "@/Components/Game/GameStyles";
import * as CS from "@/Styles/CommonStyles";

const BallCountBoard = () => {
  // 나중엔 ballcountrow쯤으로 관리하고 type이랑 count props를 내려주는 방향으로 리펙토링
  return (
    <S.BallCountBoard.BallCountBoard>
      <CS.BOX.FLEX_ROW_CENTER_BOX>
        <BallJudgement type={"S"} />
        <BallCount type={"STRIKE"} />
        <BallCount type={"STRIKE"} />
      </CS.BOX.FLEX_ROW_CENTER_BOX>
      <CS.BOX.FLEX_ROW_CENTER_BOX>
        <BallJudgement type={"B"} />
        <BallCount type={"BALL"} />
        <BallCount type={"BALL"} />
      </CS.BOX.FLEX_ROW_CENTER_BOX>
      <CS.BOX.FLEX_ROW_CENTER_BOX>
        <BallJudgement type={"O"} />
        <BallCount type={"OUT"} />
      </CS.BOX.FLEX_ROW_CENTER_BOX>
    </S.BallCountBoard.BallCountBoard>
  );
};

export default BallCountBoard;
