import styled from 'styled-components'
import GameSelect from 'components/GameHome/GameSelect'

const GameItem = ({ game_id, home, away, isStart }) => {
    
  return (
    <ItemWrapper>
        <GameTitle>GAME {game_id+1}</GameTitle>
        <GameSelect {...{home, away, isStart}}/>
    </ItemWrapper>
  )
}
export default GameItem

const ItemWrapper = styled.li`

`

const GameTitle = styled.h6`
    
`