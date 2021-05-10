import styled, { css } from 'styled-components';

const Span = ({ children, ...rest }) => {
  return <StyledSpan {...rest}>{children}</StyledSpan>;
};

export default Span;

const StyledSpan = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  color: ${({ theme, color }) =>
    color ? `${theme.colors[color]}` : `${theme.colors.white}`};

  position: relative;

  ${({ selected }) =>
    selected &&
    css`
      &::after {
        content: 'Player';
        color: red;
        font-size: 1rem;
        position: absolute;
        top: 90%;
        left: 50%;
        transform: translateX(-50%);
      }
    `};
`;
