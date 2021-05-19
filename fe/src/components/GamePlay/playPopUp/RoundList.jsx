import styled from 'styled-components'
import { IoBaseballOutline } from 'react-icons/io5'

const RoundList = ({ team, data }) => {
  data.map(v => (v + 1 ? <Span>{v}</Span> : <Span>{''}</Span>))
  return (
    <StyledRoundList>
      <Span>{team}</Span>
    </StyledRoundList>
  )
}

export default RoundList
const scoreList = new Array(12).fill('')

const StyledRoundList = styled.div`
  display: flex;
`
const Span = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  color: ${({ theme, color }) =>
    color ? `${theme.colors[color]}` : `${theme.colors.white}`};
`
