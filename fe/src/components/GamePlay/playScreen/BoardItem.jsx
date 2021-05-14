import { useContext } from 'react'
import styled from 'styled-components'

import PutComponent from './PutComponent'
import { gamePlayContext } from 'components/GamePlay/GamePlay'

const BoardItem = ({ B, S, idx, type, playerName }) => {
  const {
    isAttacking,
    round,
    home,
    away,
    dispatchAwayCurrentPlayerState,
    dispatchHomeCurrentPlayerState
  } = useContext(gamePlayContext)

  // 팀스코어 testData 수정해야함
  const teamScore = 0
  const teamName = isAttacking
    ? home.team_info.team_name
    : away.team_info.team_name

  const hit = type === '안타'
  const postPlayerData = { round, teamName, teamScore, playerName, hit }
  if (type === '안타' || type === '아웃')
    return (
      <PutComponent
        data={postPlayerData}
        {...{
          isAttacking,
          dispatchHomeCurrentPlayerState,
          dispatchAwayCurrentPlayerState
        }}
      />
    )

  return (
    <Lists>
      <Number>{idx + 1}</Number>
      <span>{type}</span>
      <span>
        S{S} B{B}
      </span>
    </Lists>
  )
}

export default BoardItem

const Lists = styled.li`
  display: flex;
`

const Number = styled.div`
  background-color: ${({ theme }) => theme.colors.white};
  display: flex;
  justify-content: center;
  align-items: center;
  border-radius: 50%;
  width: 1.5rem;
  height: 1.5rem;
  color: ${({ theme }) => theme.colors.black};
`
