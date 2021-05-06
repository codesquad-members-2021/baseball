import { ScoreBoardStyles as S } from '../ScoreBoardStyles';
import AttackTeamTag from '../Teams/AttackTeamTag';
import TeamNameBox from '../Teams/TeamNameBox';
import ScoreItem from './ScoreItem';

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
