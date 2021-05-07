import HomeTitle from '@/Components/Home/HomeTitle';
import MatchInfo from './MatchInfo/MatchInfo';
import { HomeStyles as S } from '@/Components/Home/HomeStyles';

const Home = () => {
  const backgroundUrl =
    'https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png';
  return (
    <>
      <S.Background src={backgroundUrl} />
      <S.Home>
        <HomeTitle />
        <MatchInfo />
      </S.Home>
    </>
  );
};

export default Home;
