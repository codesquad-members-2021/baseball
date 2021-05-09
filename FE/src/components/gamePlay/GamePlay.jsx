import styled from 'styled-components';
import GameScore from './gameScore/GameScore';
import MatchScreen from './matchScreen/MatchScreen';
import BattleGround from './battleGround/BattleGround';
import SituationScreen from './situationScreen/SituationScreen';

const GamePlay = () => {
    return (
        <StyledGamePlay>
            <GamePlayItems>
                <li><GameScore /></li>
                <li><MatchScreen /></li>
                <li><BattleGround /></li>
                <li><SituationScreen /></li>
            </GamePlayItems>
        </StyledGamePlay>
    );
};

export default GamePlay;

// --- Styled Components ---
const StyledGamePlay = styled.div`
    min-width: 100%;
    color: ${({ theme }) => theme.colors.white};
`;

const GamePlayItems = styled.ul`
    display: grid;
    grid-template-columns: 3fr 1fr;

    li {
        padding: 24px;
    }
    li:nth-child(1),
    li:nth-child(2) {
        border-bottom: 3px solid ${({ theme }) => theme.colors.white};
    }

    li:nth-child(2n) {
        border-left: 3px solid ${({ theme }) => theme.colors.white};
    }
`;
