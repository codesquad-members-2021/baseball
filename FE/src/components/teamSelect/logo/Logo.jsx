// CPR BASSBALL GAME
import styled from "styled-components";

const Logo = ({children}) => (<StyledLogo>{children}</StyledLogo>);

export default Logo;

// --- Styled Components ---
const StyledLogo = styled.span`
    margin: 60px 0;

    font-size: 32px;
    font-weight: 700;
    color: #FFF;
`;