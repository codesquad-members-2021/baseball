import styled from 'styled-components';
import SelectTemplate from './selectTemplate/SelectTemplate';
import Logo from './logo/Logo';

const TeamSelect = () => {
    return (
        <StyledTeamSelect>
            <Logo>CPR BASSBALL GAME</Logo>
            <SelectTemplate />
        </StyledTeamSelect>
    );
};

export default TeamSelect;

// --- Styled Components ---
const StyledTeamSelect = styled.div`
    width: 60%;
    height: 100%;
    text-align: center;
    margin: 0 auto;
`;
