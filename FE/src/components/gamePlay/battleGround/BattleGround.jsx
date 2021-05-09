import styled from 'styled-components';

const BattleGround = () => {
    return <StyledBattleGround>BattleGround</StyledBattleGround>;
};

export default BattleGround;

// --- Styled Components ---
const StyledBattleGround = styled.div`
    background-image: url('./images/background.jpg');
    background-repeat: no-repeat;
    background-size: cover;
    min-height: 850px;
`;