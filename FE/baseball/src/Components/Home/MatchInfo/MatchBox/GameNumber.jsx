import { MatchBox as S } from '@/Components/Home/HomeStyles';
import { GAME } from '@/Utils/const';

const GameNumber = ({ idx }) => {
  return (
    <S.GameNumber>
      {GAME} {idx + 1}
    </S.GameNumber>
  );
};

export default GameNumber;
