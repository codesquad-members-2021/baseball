import styled from "styled-components";
import Logo from "../../utilComponent/Logo";
import GameScoreStatus from "./GameScoreStatus";

const GameScore = () => {
    return (
        <StyledGameScore>
            <Logo>CPR BASSBALL GAME</Logo>
            <GameScoreStatus />
        </StyledGameScore>
    );
};

export default GameScore;

// --- Styled Components ---
const StyledGameScore = styled.div`
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column; 
`;