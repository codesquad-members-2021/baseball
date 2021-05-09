import styled from "styled-components";
import SituationRecord from "./SituationRecord";
import SituationStatus from "./SituationStatus";

const Situation = (/*{data} */) => {
    return (
        <StyledSituation>
            {/* <SituationStatus type="now" player={{id: 2, name: '이용대'}} /> */}
            <SituationStatus player={{id: 1, name: '류현진'}} status={'안타'} />
            <SituationRecord />
        </StyledSituation>
    );
};

export default Situation;

// --- Styled Components ---
const StyledSituation = styled.div`
    font-size: ${({theme}) => theme.fontSize.S};
    font-weight: ${({theme}) => theme.fontWeight.bold};

    & + & {
        margin-top: 32px;
    }
`;