import { ScoreBoardStyles as S } from '../ScoreBoardStyles';
import AttackTeamTag from '../Teams/AttackTeamTag';
import TeamName from '../Teams/TeamName';
import ScoreItem from './ScoreItem';

const ScoreRow = ({ teamName }) => {
  return (
    <S.ScoreRow>
      <AttackTeamTag />
      <TeamName teamName={teamName} />
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
