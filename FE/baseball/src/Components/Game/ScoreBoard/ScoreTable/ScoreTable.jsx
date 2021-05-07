import ScoreRow from './ScoreRow';
import ScoreRowHead from './ScoreRowHead';
import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';

const ScoreTable = () => {
  return (
    <S.ScoreTable>
      <ScoreRowHead />
      <S.ScoreMiddleLine />
      <ScoreRow teamName={'DOOSAN'} />
      <ScoreRow teamName={'NC'} />
    </S.ScoreTable>
  );
};

export default ScoreTable;
