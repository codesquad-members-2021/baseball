import styled from 'styled-components'

const Span = ({ size, weight,  children }) => {
  return <StyledSpan size={size} weight={weight}>{children}</StyledSpan>
}

export default Span

const StyledSpan = styled.span`
  font-size: ${props => `${props.size}rem`};
  font-weight:  ${props => `${props.weight}`};
`
