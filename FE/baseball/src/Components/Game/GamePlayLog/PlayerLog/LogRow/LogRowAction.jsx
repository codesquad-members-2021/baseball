import { GamePlayLog as S } from "@/Components/Game/GameStyles";

const LogRowAction = ({ action }) => {
  // let isEndAction;
  // if (action === "안타" || action === "아웃" || action === "홈런") {
  //   isEndAction = true;
  // } else {
  //   isEndAction = false;
  // }
  return (
    <S.PlayerLog.LogRowAction isEndAction={true}>
      스트라이크
    </S.PlayerLog.LogRowAction>
  );
};

export default LogRowAction;
