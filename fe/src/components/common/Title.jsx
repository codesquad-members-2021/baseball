import styled from 'styled-components'

const Title = ({ children, size }) => {
  return <GameTitle size={size}>{children}</GameTitle>
}

export default Title;

const GameTitle = styled.h1`
  font-size: ${props => (props.size === 'L' ? '4rem' : '2rem')};
  font-weight: 750;
  color: #fff;
  margin: 1rem 0;
`