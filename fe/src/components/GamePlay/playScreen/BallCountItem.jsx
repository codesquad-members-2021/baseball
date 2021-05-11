import styled from 'styled-components'


const BallCountItem = ({ BSO, count }) => {
  let counts = new Array(count).fill(<StyledCount BSO={BSO} />)
  return (
    <StyledCountItem>
      <BsoSpan>{BSO}</BsoSpan>
      {counts}
    </StyledCountItem>
  )
}

export default BallCountItem

const BsoSpan = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  width: 2rem;
  line-height: 1;
  padding-bottom: 0.6rem;
`

const StyledCountItem = styled.div`
  display: flex;
  align-items: center;
`
const StyledCount = styled.div`
  margin-left: 1rem;
  border-radius: 50%;
  width: 2rem;
  height: 2rem;
  background-color: ${props => {
    switch (props.BSO) {
      case 'B':
        return props.theme.colors.ballGreen
      case 'S':
        return props.theme.colors.ballYellow
      case 'O':
        return props.theme.colors.ballRed
      default:
    }
  }};
`
