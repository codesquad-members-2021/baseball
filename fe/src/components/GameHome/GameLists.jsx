import GameItem from 'components/GameHome/GameItem'
import styled from 'styled-components'
import { v4 as uuidv4 } from 'uuid'

const GameLists = ({ data }) => {
  const gameItems = data.map(({ home, away, isStart, game_id }) => (
    <GameItem key={uuidv4()} {...{ home, away, isStart, game_id }} />
  ))
  return <StyledGameLists>{gameItems}</StyledGameLists>
}

export default GameLists

const StyledGameLists = styled.ul`
  height: 27rem;
  overflow-y: hidden;
  &:hover {
    overflow-y: scroll;
    &::-webkit-scrollbar {
      width: 0px;
      background-color: black;
    }
  }
`
