import styled from "styled-components";

const Round = () => {
    return (
        <StyledRound>
            2회초 수비
        </StyledRound>
    );
};

export default Round;

// --- Styled Components ---
const StyledRound = styled.span`
    font-size: ${({theme}) => theme.fontSize.XXL};
    font-weight: ${({theme}) => theme.fontWeight.bold};
`;