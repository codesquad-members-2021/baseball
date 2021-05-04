import Score from "./Score";
import TeamName from "./TeamName";
import VS from "./VS";
import { GameHeader as S } from "@/Components/Game/GameStyles";

const GameProgress = () => {
  return (
    <S.GameProgress.GameProgress>
      <TeamName isCurrentPlayer={true} />
      <Score score={1} />
      <VS />
      <Score score={5} />
      <TeamName isCurrentPlayer={false} />
    </S.GameProgress.GameProgress>
  );
};

export default GameProgress;
