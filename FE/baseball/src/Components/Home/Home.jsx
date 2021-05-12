import HomeTitle from '@/Components/Home/HomeTitle';
import MatchInfo from './MatchInfo/MatchInfo';
import { HomeStyles as S } from '@/Components/Home/HomeStyles';
import { BACKGROUND_URL } from '@/Utils/const';

const Home = () => {
  return (
    <>
      <S.Background src={BACKGROUND_URL} />
      <S.Home>
        <HomeTitle />
        <MatchInfo />
      </S.Home>
    </>
  );
};

export default Home;
