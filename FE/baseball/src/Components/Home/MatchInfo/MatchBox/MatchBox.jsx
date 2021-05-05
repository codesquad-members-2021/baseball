import GameNumber from './GameNumber';
import Match from './Match';
import { HomeStyles as S } from '@/Components/Home/HomeStyles';

const MatchBox = () => {
  return (
    <S.MatchBox>
      <GameNumber />
      <Match />
    </S.MatchBox>
  );
};

export default MatchBox;
