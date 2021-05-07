import GameNumber from './GameNumber';
import Match from './Match';
import { MatchBox as S } from '@/Components/Home/HomeStyles';

const MatchBox = () => {
  return (
    <S.MatchBox>
      <GameNumber />
      <Match />
    </S.MatchBox>
  );
};

export default MatchBox;
