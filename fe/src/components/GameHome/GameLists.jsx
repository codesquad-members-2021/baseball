import GameItem from 'components/GameHome/GameItem'
import styled, { keyframes } from 'styled-components'
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
  overflow-y: scroll;
  &::-webkit-scrollbar {
    width: 10px;
    background-color: transparent;
  }
  &::-webkit-scrollbar-thumb {
    background-color: transparent;
    border-radius: 10px;
  }
  &::-webkit-scrollbar-track {
    background-color: transparent;
    border-radius: 10px;
  }
  &:hover {
    &::-webkit-scrollbar {
      background-color: black;
    }
    &::-webkit-scrollbar-thumb {
      background-color: #2f3542;
    }
    &::-webkit-scrollbar-track {
      background-color: grey;
    }
  }
`

