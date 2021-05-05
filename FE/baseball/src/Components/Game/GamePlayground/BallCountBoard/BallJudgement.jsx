import { GamePlayground as S } from "@/Components/Game/GameStyles";

const BallJudgement = ({ type }) => {
  return (
    <S.BallCountBoard.BallJudgement>{type}</S.BallCountBoard.BallJudgement>
  );
};

export default BallJudgement;
