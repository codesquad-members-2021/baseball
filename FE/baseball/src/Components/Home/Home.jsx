import HomeTitle from '@/Components/Home/HomeTitle';
import MatchInfo from './MatchInfo/MatchInfo';
import { HomeStyles as S } from '@/Components/Home/HomeStyles';

const Home = () => {
  return (
    <S.Home>
      <HomeTitle />
      <MatchInfo />
    </S.Home>
  );
};

export default Home;
