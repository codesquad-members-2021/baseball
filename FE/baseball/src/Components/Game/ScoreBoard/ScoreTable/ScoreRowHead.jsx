import { BLANK } from '@/Utils/const';
import { ScoreBoardStyles as S } from '../ScoreBoardStyles';
import TeamName from '../Teams/TeamName';

import ScoreItem from './ScoreItem';

const ScoreRowHead = () => {
  return (
    <S.ScoreRowHead>
      <TeamName teamName={BLANK} />
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
    </S.ScoreRowHead>
  );
};

export default ScoreRowHead;
