import GameStartButton from '@/Components/Intro/GameStartButton';
import { IntroStyles as S } from '@/Components/Intro/IntroStyles';
import { BACKGROUND_URL } from '@/Utils/const';

const Intro = () => {
  return (
    <>
      <S.Background src={BACKGROUND_URL} />
      <S.Intro>
        <GameStartButton />
      </S.Intro>
    </>
  );
};

export default Intro;
