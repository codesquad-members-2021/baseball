import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';
import { PLAYER } from '@/Utils/const';

const CurrentPlayerTag = ({ isPlayer }) => {
  if (!isPlayer) return null;
  return <S.CurrentPlayerTag>{PLAYER}</S.CurrentPlayerTag>;
};

export default CurrentPlayerTag;
