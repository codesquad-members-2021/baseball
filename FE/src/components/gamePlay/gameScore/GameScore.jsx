import styled from "styled-components";
import { cssFlexAlignCenter } from "../../utilComponent/CommonStyledCSS";
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
    ${cssFlexAlignCenter};
    flex-direction: column; 
`;