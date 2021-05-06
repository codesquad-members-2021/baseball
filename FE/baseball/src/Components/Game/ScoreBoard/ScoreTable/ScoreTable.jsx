import { ScoreBoardStyles as S } from '../ScoreBoardStyles';
import ScoreRow from './ScoreRow';
import ScoreRowHead from './ScoreRowHead';

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
