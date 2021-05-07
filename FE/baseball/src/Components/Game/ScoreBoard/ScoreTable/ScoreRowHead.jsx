import AttackTeamTag from '@/Components/Game/ScoreBoard/Teams/AttackTeamTag';
import TeamName from '@/Components/Game/ScoreBoard/Teams/TeamName';
import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';
import { BLANK } from '@/Utils/const';

import ScoreItem from './ScoreItem';

const ScoreRowHead = () => {
  return (
    <S.ScoreRowHead>
      <AttackTeamTag />
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
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
      <ScoreItem />
    </S.ScoreRowHead>
  );
};

export default ScoreRowHead;
