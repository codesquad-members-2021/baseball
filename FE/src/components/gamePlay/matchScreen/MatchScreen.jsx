import styled from "styled-components";
import MatchScreenPlayerInfo from "./MatchScreenPlayerInfo";

const MatchScreen = () => {
    return (
        <StyledMatchScreen>
            <MatchScreenPlayerInfo/>
            <MatchScreenPlayerInfo type="attack"/>
        </StyledMatchScreen>
    );
};

export default MatchScreen;

// --- Styled Components ---
const StyledMatchScreen = styled.div`
    height: 100%;
    display: grid;
    align-items: center;
`;