import GameTitle from './GameTitle';
import GameProgress from './GameProgress/GameProgress';
import { GameHeader as S } from '@/Components/Game/GameStyles';

const GameHeader = () => {
  return (
    <S.GameHeader>
      <GameTitle />
      <GameProgress />
    </S.GameHeader>
  );
};

export default GameHeader;
