import Title from 'components/common/Title'
import styled from 'styled-components'
import FlexCenter from 'styles/FlexCenter'
import HeaderScore from 'components/GamePlay/playHeader/HeaderScore'

const HeaderLeft = () => {

  return (
    <StyledHeaderLeft>
      <Title size={'S'}>BASEBALL ONLINE GAME</Title>
      <HeaderScore/>
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
