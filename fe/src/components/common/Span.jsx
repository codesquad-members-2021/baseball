import styled from 'styled-components';

const Span = ({ children, ...rest }) => {
  return <StyledSpan {...rest}>{children}</StyledSpan>;
};

export default Span;

const StyledSpan = styled.span`
  font-size: ${({ size }) => `${size}rem`};
  font-weight: ${({ weight }) => `${weight}`};
  text-decoration: ${({ selected }) => (selected ? 'underline' : null)};
`;
// underline style 적용 필요
