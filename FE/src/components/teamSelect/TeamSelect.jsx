import styled from 'styled-components';
import SelectTemplate from './selectTemplate/SelectTemplate';
import Logo from '../utilComponent/Logo';

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
    width: 50%;
    margin: 0 auto;
    text-align: center;
`;
