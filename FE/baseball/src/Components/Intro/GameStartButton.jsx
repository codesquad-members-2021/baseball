import GameTitle from '@/Components/Intro/GameTitle';
import { IntroStyles as S } from '@/Components/Intro/IntroStyles';
import { Link } from 'react-router-dom';

const GameStartButton = () => {
  return (
    <Link to="/home">
      <S.GameStartButton>
        <GameTitle />
      </S.GameStartButton>
    </Link>
  );
};
export default GameStartButton;
