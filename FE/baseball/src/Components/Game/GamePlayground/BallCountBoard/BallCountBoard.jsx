import BallJudgement from "./BallJudgement";
import BallCount from "./BallCount";
import { GamePlayground as S } from "@/Components/Game/GameStyles";
import * as CS from "@/Styles/CommonStyles";

const BallCountBoard = ({ ballCount }) => {
  const sortBall = (type) => {
    let sortedBall = [];
    let ballCountLength;
    if (type === "STRIKE") {
      ballCountLength = ballCount.strike;
    } else if (type === "BALL") {
      ballCountLength = ballCount.ball;
    } else {
      ballCountLength = ballCount.out;
    }

    for (let i = 0; i < ballCountLength; i++) {
      sortedBall.push(<BallCount key={i} type={type} />);
    }
    return sortedBall;
  };
  return (
    <S.BallCountBoard.BallCountBoard>
      <CS.BOX.FLEX_ROW_CENTER_BOX>
        <BallJudgement type={"S"} />
        {sortBall("STRIKE")}
      </CS.BOX.FLEX_ROW_CENTER_BOX>
      <CS.BOX.FLEX_ROW_CENTER_BOX>
        <BallJudgement type={"B"} />
        {sortBall("BALL")}
      </CS.BOX.FLEX_ROW_CENTER_BOX>
      <CS.BOX.FLEX_ROW_CENTER_BOX>
        <BallJudgement type={"O"} />
        {sortBall("OUT")}
      </CS.BOX.FLEX_ROW_CENTER_BOX>
    </S.BallCountBoard.BallCountBoard>
  );
};

export default BallCountBoard;
