import GameTitle from '@/Components/Intro/GameTitle';
import { Link } from 'react-router-dom';
import { IntroStyles as S } from '@/Components/Intro/IntroStyles';

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
