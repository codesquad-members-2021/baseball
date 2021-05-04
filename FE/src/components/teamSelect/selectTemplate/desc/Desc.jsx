// 참가할 게임을 선택하세요
import styled from 'styled-components';

const Desc = ({ children }) => <StyledDesc>{children}</StyledDesc>;

export default Desc;

// --- Styled Components ---
const StyledDesc = styled.div`
    font-size: ${({ theme }) => theme.fontSize.XL};
    font-weight: ${({ theme }) => theme.fontWeight.bold};
    color: ${({ theme }) => theme.colors.white};
`;
