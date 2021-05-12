import CurrentPlayerTag from './CurrentPlayerTag';
import TeamName from './TeamName';
import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';

const TeamNameBox = ({ team, isPlayer }) => {
  return (
    <S.TeamNameBox>
      <TeamName {...{ team }} />
      <CurrentPlayerTag {...{ isPlayer }} />
    </S.TeamNameBox>
  );
};

export default TeamNameBox;
