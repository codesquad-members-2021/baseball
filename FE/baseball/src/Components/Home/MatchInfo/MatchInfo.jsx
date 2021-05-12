import MatchInfoBody from './MatchInfoBody';
import MatchInfoTitle from './MatchInfoTitle';
import { MatchInfo as S } from '@/Components/Home/HomeStyles';

const MatchInfo = () => {
  return (
    <S.MatchInfo>
      <MatchInfoTitle />
      <MatchInfoBody />
    </S.MatchInfo>
  );
};

export default MatchInfo;
