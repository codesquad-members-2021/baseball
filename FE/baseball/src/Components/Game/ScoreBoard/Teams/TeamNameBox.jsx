import CurrentPlayerTag from './CurrentPlayerTag';
import TeamName from './TeamName';
import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';

const TeamNameBox = ({ teamName }) => {
  return (
    <S.TeamNameBox>
      <TeamName teamName={teamName} />
      <CurrentPlayerTag />
    </S.TeamNameBox>
  );
};

export default TeamNameBox;
