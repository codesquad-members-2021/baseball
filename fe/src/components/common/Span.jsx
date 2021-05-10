import styled from 'styled-components';

const Span = ({ children }) => {
  return <StyledSpan>{children}</StyledSpan>;
};

export default Span;

const StyledSpan = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  text-decoration: ${({ selected }) => (selected ? 'underline' : null)};
`;
// underline style 적용 필요
