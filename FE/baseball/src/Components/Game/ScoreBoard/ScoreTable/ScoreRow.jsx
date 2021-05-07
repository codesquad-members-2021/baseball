import AttackTeamTag from '@/Components/Game/ScoreBoard/Teams/AttackTeamTag';
import TeamNameBox from '@/Components/Game/ScoreBoard/Teams/TeamNameBox';
import ScoreItem from './ScoreItem';
import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';

const ScoreRow = ({ teamName }) => {
  return (
    <S.ScoreRow>
      <AttackTeamTag />
      <TeamNameBox teamName={teamName} />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
    </S.ScoreRow>
  );
};

export default ScoreRow;
