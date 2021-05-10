import GameNumber from './GameNumber';
import Match from './Match';
import { MatchBox as S } from '@/Components/Home/HomeStyles';

const MatchBox = ({ match, idx }) => {
  return (
    <S.MatchBox>
      <GameNumber {...{ idx }} />
      <Match {...{ match }} />
    </S.MatchBox>
  );
};

export default MatchBox;
