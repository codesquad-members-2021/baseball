import GameContainer from 'components/GameHome/GameContainer'
import { Link } from 'react-router-dom'
import styled from 'styled-components'

const Home = () => {
 
  return (
    <Main>
        <GameContainer/>
    </Main>
  )
}

export default Home

const Main = styled.main`
    margin: 0 auto;
    width: 100%;
    display: flex;
    justify-content: center;
`
