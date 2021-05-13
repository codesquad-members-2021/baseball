import styled, { keyframes } from 'styled-components'
import { useState } from 'react'
const PopUp = ({ children, type }) => {
  const [active, setActive] = useState(false)

  return active ? (
    <StyledPopUp onClick={() => setActive(false)}>
      <PopUpWarpper {...{ type }}>{children}</PopUpWarpper>
    </StyledPopUp>
  ) : (
    <WaitingPopUp {...{ type }} onMouseEnter={() => setActive(true)} />
  )
}

export default PopUp

const popUpAnimation = keyframes`
0% {
  transform: translateY(-5rem);
  opacity: 0;
}
100%{
  transform: translateY(0);
  opacity: 1;
}

`
const popDownAnimation = keyframes`
0% {
  transform: translateY(5rem); 
  opacity: 0;
100%{
  transform: translateY(0);
  opacity: 1;
}

`

const PopUpWarpper = styled.div`
  animation: ${({ type }) => {
      if (type === 'up') return popUpAnimation
      else return popDownAnimation
    }}
    0.3s ease-in;
`

const StyledPopUp = styled.section`
  position: fixed;
  z-index: 9999;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.8);
`
const WaitingPopUp = styled.section`
  position: fixed;
  z-index: 9999;
  width: 100%;
  height: 5%;
  ${({ type }) => {
    if (type === 'up') return 'top: 0'
    else return 'bottom: 0'
  }};
  background-color: red;
`
