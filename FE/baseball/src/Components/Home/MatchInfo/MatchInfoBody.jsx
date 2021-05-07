import MatchBox from './MatchBox/MatchBox';
import { MatchInfo as S } from '@/Components/Home/HomeStyles';

const MatchInfoBody = () => {
  return (
    <S.ScrollMask>
      <S.MatchInfoBody>
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
      </S.MatchInfoBody>
    </S.ScrollMask>
  );
};

export default MatchInfoBody;
