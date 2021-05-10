import styled from 'styled-components'
import BallCount from 'components/GamePlay/playScreen/BallCount'
import Span from 'components/common/Span'
const Screen = () => {
  return (
    <StyledScreen>
      <ScreenField src='field.svg' alt='field' />
      <ScreenRound>2회 초 수비</ScreenRound>
      <BallCount />
    </StyledScreen>
  )
}

export default Screen

const StyledScreen = styled.section`
  display: flex;
  justify-content: center;
  width: 70%;
  height: 100%;
  background-image: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
    url('https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png');
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
`

const ScreenField = styled.img`
  width: 34%;
  transform: rotate(45deg);
`
const ScreenRound = styled(Span)`
  position: absolute;
  right: 2%;
  top: 4%;
`
