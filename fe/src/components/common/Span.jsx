import styled, { css } from 'styled-components';

const Span = ({ children, ...rest }) => {
  return <StyledSpan {...rest}>{children}</StyledSpan>;
};

export default Span;

const StyledSpan = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  padding-bottom: ${({ selected }) => (selected ? null : `1rem`)};
  color: ${({ theme, color }) =>
    color ? `${theme.colors[color]}` : `${theme.colors.white}`};

  ${({ selected }) =>
    selected &&
    css`
      &::after {
        content: 'Player';
        display: block;
        color: red;
        font-size: 1rem;
        text-align: center;
      }
    `};
`;
