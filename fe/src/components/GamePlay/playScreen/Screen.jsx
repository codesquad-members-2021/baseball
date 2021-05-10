import styled from 'styled-components'

const Screen = () => {
  return (
    <StyledScreen>
      <ScreenField src='field.svg' alt='field' />
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
`

const ScreenField = styled.img`
  width: 34%;
  transform: rotate(45deg);
`
