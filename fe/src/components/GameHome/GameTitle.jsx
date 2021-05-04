import styled from 'styled-components'
const GameTitle = ({ children, size }) => {
  return <Title size={size}>{children}</Title>
}

export default GameTitle

const Title = styled.h1`
  font-size: ${props => (props.size === 'L' ? '4rem' : '2rem')};
  font-weight: 750;
  color: black;
`
