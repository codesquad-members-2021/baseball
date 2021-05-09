import styled from "styled-components";
import Situation from "./situation/Situation";

const SituationScreen = () => {
    return (
        <StyledSituationScreen>
            {[...Array(3)].map((_, i) => <Situation key={i} />)}
        </StyledSituationScreen>
    );
};

export default SituationScreen;

// --- Styled Components ---
const StyledSituationScreen = styled.div`

`;