import styled from 'styled-components';
import Span from 'components/common/Span';

const VsSpan = ({ children, ...rest }) => {
  return <StyledSpan {...rest}>{children}</StyledSpan>;
};

export default VsSpan;

const StyledSpan = styled(Span)`
  color: ${({ theme }) => theme.colors.lightGray};
`;
