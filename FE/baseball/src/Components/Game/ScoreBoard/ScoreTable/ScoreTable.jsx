import ScoreRow from './ScoreRow';
import ScoreRowHead from './ScoreRowHead';
import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';
import { scores } from '../temp_Scores';

const ScoreTable = () => {
  const awayScores = scores.away;
  const homeScores = scores.home;

  return (
    <S.ScoreTable>
      <ScoreRowHead />
      <S.ScoreMiddleLine />
      <ScoreRow scores={awayScores} isPlayer={true} />
      <ScoreRow scores={homeScores} isPlayer={false} />
    </S.ScoreTable>
  );
};

export default ScoreTable;
