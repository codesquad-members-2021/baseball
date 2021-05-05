import { HomeStyles as S } from '@/Components/Home/HomeStyles';
import MatchBox from './MatchBox/MatchBox';

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
