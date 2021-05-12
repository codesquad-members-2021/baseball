import AttackTeamTag from '@/Components/Game/ScoreBoard/Teams/AttackTeamTag';
import TeamName from '@/Components/Game/ScoreBoard/Teams/TeamName';
import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';
import { BLANK, defaultInning } from '@/Utils/const';
import { v4 as uuidv4 } from 'uuid';

import ScoreItem from './ScoreItem';

const ScoreRowHead = () => {
  return (
    <S.ScoreRowHead>
      <AttackTeamTag isAttack={false} />
      <TeamName teamName={BLANK} />
      {defaultInning.map((inning) => (
        <ScoreItem key={uuidv4()} {...{ inning }} />
      ))}
    </S.ScoreRowHead>
  );
};

export default ScoreRowHead;
