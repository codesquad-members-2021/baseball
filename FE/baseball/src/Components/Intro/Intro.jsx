import { IntroStyles as S } from '@/Components/Intro/IntroStyles';
import GameStartButton from '@/Components/Intro/GameStartButton';

const Intro = () => {
  const backgroundUrl =
    'https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png';
  return (
    <>
      <S.Background src={backgroundUrl} />
      <S.Intro>
        <GameStartButton />
      </S.Intro>
    </>
  );
};

export default Intro;
