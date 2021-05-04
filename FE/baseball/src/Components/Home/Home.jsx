import HomeStyles from '@/Components/Home/HomeStyles';
import HomeTitle from '@/Components/Home/HomeTitle';
import MatchInfo from './MatchInfo/MatchInfo';

const Home = () => {
  return (
    <HomeStyles>
      <HomeTitle />
      <MatchInfo />
    </HomeStyles>
  );
};

export default Home;
