import styled from 'styled-components'
import BallCountItem from 'components/GamePlay/playScreen/BallCountItem'
const BallCount = () => {
  return (
    <StyledBallCount>
      <BallCountItem BSO={'B'} count={3} />
      <BallCountItem BSO={'S'} count={3} />
      <BallCountItem BSO={'O'} count={2} />
    </StyledBallCount>
  )
}

export default BallCount

const StyledBallCount = styled.div`
  display: flex;
  flex-direction: column;
  color: white;
  position:absolute;
  left: 2%;
  top: 3%;
`
