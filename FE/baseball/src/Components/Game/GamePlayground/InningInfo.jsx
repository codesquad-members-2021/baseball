import { GamePlayground as S } from "@/Components/Game/GameStyles";

const InningInfo = ({ inningInfo }) => {
  let infoText = `${inningInfo.inning}회${inningInfo.inningCount} 
  ${inningInfo.isDefense ? "수비" : "공격"}`;

  return <S.InningInfo>{infoText}</S.InningInfo>;
};

export default InningInfo;
