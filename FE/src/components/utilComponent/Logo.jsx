// CPR BASSBALL GAME
import styled from 'styled-components';

const Logo = ({ children, ...props }) => <StyledLogo {...props}>{children}</StyledLogo>;

export default Logo;

// --- Styled Components ---
const StyledLogo = styled.div`
    font-size: ${({ theme, fontSize }) => fontSize || theme.fontSize.XXXL};
    font-weight: ${({ theme }) => theme.fontWeight.bold2};
    color: ${({ theme }) => theme.colors.white};
`;