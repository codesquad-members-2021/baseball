import GameTitle from 'components/GameHome/GameTitle'
import styled from 'styled-components'
import GameLists from 'components/GameHome/GameLists'
import useFetch from 'hooks/useFetch'
// import dotenv from 'dotenv'
// dotenv.config()
const GameContainer = () => {
 const data = useFetch(process.env.REACT_APP_API_URL + "/data.json")
  console.log(data)
  return (
    <GameSection>
      <GameTitle size={'L'}>BASEBALL GAME ONLINE</GameTitle>
      <GameNotice>참가할 게임을 선택하세요.</GameNotice>
      <GameLists></GameLists>
    </GameSection>
  )
}

export default GameContainer
const GameSection = styled.section`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`
const GameNotice = styled.span`
  color: #fff;
  font-size: 2rem;
`
