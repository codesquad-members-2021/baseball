import { useContext } from 'react'
import Title from 'components/common/Title'
import styled from 'styled-components'
import FlexCenter from 'styles/FlexCenter'
import {gamePlayContext} from 'pages/Game'

const HeaderLeft = () => {
  const {home, away} = useContext(gamePlayContext);
  console.log(home, away);
  return (
    <StyledHeaderLeft>
      <Title size={'S'}>BASEBALL ONLINE GAME</Title>
      <span>Captain 1 vs 5 Mavel</span>
    </StyledHeaderLeft>
  )
}

export default HeaderLeft

const StyledHeaderLeft = styled(FlexCenter)`
  width: 70%;
  height: 100%;
  flex-direction: column; 
  span {
    color: #fff;
  }
`
