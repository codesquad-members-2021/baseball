import styled from 'styled-components'

const Screen = () => {
  return (
    <StyledScreen>
      <ScreenField src='field.svg' alt='field' />
      <ScreenRound>2회 초 수비</ScreenRound>
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
const ScreenRound = styled.span`
  position: absolute;
  right: 2%;
  top: 2%;
  color: ${props => props.theme.colors.white};
  font-size: ${props => `${props.theme.fontSizes.LARGE}rem`};
  font-weight: ${props => props.theme.weights.LARGE};
`
