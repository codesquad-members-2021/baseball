import { ScoreBoardStyles as S } from '../ScoreBoardStyles';
import CurrentPlayerTag from './CurrentPlayerTag';
import TeamName from './TeamName';

const TeamNameBox = ({ teamName }) => {
  return (
    <S.TeamNameBox>
      <TeamName teamName={teamName} />
      <CurrentPlayerTag />
    </S.TeamNameBox>
  );
};

export default TeamNameBox;
