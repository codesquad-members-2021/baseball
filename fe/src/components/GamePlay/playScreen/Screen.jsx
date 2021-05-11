import styled, { keyframes } from 'styled-components'
import BallCount from 'components/GamePlay/playScreen/BallCount'
import { IoIosBaseball } from 'react-icons/io'
import Span from 'components/common/Span'
const Screen = () => {
  return (
    <StyledScreen>
      <ScreenField src='field.svg' alt='field' />
      <ScreenRound>2회 초 수비</ScreenRound>
      <PitchButton>
        <IoIosBaseball />
      </PitchButton>
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
const ScreenRound = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  color: ${({ theme }) => `${theme.colors.white}`};
  position: absolute;
  right: 2%;
  top: 4%;
`
const buttonAnimation = keyframes`

100% {
    	transform: rotate(360deg);
    }
`

const PitchButton = styled.button`
  height: 5rem;
  position: absolute;
  left: 47%;
  top: 43%;
  cursor: pointer;
  font-size: 5rem;
  color: white;
  background: none;
  &:hover {
    /* transition: ease-in 0.5s; */
    animation: ${buttonAnimation} 5s linear infinite;
    transform-origin: 50% 50%;
  }
`
