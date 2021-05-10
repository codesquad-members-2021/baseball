import styled from 'styled-components'

const Span = ({ size, weight, selected ,children }) => {
  return <StyledSpan size={size} weight={weight} selected={selected}>{children}</StyledSpan>
}

export default Span

const StyledSpan = styled.span`
  font-size: ${props => `${props.size}rem`};
  font-weight:  ${props => `${props.weight}`};
  text-decoration: ${props => props.selected ? 'underline': null};
`
// underline style 적용 필요