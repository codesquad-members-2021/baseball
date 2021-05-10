import styled from 'styled-components';

const VsSpan = ({ children, ...rest }) => {
  return <StyledSpan {...rest}>{children}</StyledSpan>;
};

export default VsSpan;

const StyledSpan = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  color: ${({ theme }) => theme.colors.lightGray};
`;
