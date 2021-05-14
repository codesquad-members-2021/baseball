import styled from "styled-components";
import SituationRecord from "./SituationRecord";
import SituationStatus from "./SituationStatus";

const Situation = ({number, name, situation}) => {
    return (
        <StyledSituation>
            {<div>
                {number && <SituationStatus  player={{id: number, name: name}}/>}
                {situation && <SituationRecord status={situation} />}
            </div>}
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