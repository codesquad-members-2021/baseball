import styled from 'styled-components';

const Title = ({ children, size }) => {
  return <GameTitle size={size}>{children}</GameTitle>;
};

export default Title;

const GameTitle = styled.h1`
  font-size: ${({ size, theme }) =>
    size === 'L'
      ? `${theme.fontSizes.TITLEL}rem`
      : `${theme.fontSizes.TITLEM}rem`};

  font-weight: ${({ theme }) => theme.weights.LARGE};
  color: ${({ theme }) => theme.colors.white};

  /* margin: 1rem 0; */
`;
