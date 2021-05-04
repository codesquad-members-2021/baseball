import CurrentPlayerTag from "./CurrentPlayerTag";
import { GameHeader as S } from "@/Components/Game/GameStyles";

const TeamName = ({ teamName, isCurrentPlayer }) => {
  return (
    <S.GameProgress.TeamNameWrapper>
      <S.GameProgress.TeamName>{teamName}</S.GameProgress.TeamName>
      {isCurrentPlayer ? <CurrentPlayerTag /> : null}
    </S.GameProgress.TeamNameWrapper>
  );
};

export default TeamName;
