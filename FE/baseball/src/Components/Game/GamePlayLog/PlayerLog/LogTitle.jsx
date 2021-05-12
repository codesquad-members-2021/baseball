import { GamePlayLog as S } from "@/Components/Game/GameStyles";

const LogTitle = ({ isCurrentPlayer }) => {
  return (
    <S.PlayerLog.LogTitle isCurrentPlayer={true}>
      4번 타자 이준석
    </S.PlayerLog.LogTitle>
  );
};

export default LogTitle;
