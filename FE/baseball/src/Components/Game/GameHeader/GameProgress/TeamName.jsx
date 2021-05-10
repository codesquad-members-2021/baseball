import CurrentPlayerTag from "./CurrentPlayerTag";
import { GameHeader as S } from "@/Components/Game/GameStyles";

const TeamName = ({ teamName, selectedTeam }) => {
  return (
    <S.GameProgress.TeamNameWrapper>
      <S.GameProgress.TeamName>{teamName}</S.GameProgress.TeamName>
      {teamName === selectedTeam ? <CurrentPlayerTag /> : null}
    </S.GameProgress.TeamNameWrapper>
  );
};

export default TeamName;
