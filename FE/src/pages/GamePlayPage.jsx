import GamePlay from '../components/gamePlay/GamePlay';
import GamePlayProvider from '../components/utilComponent/context/GamePlayProvider';

const GamePlayPage = () => (
    <GamePlayProvider>
        <GamePlay />
    </GamePlayProvider>
);
export default GamePlayPage;