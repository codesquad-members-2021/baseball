import { useContext, useState } from 'react'
import styled from 'styled-components'
import { v4 as uuidv4 } from 'uuid'

import Board from 'components/GamePlay/playScreen/Board'
import { gamePlayContext } from 'components/GamePlay/GamePlay'
import BoardHistory from './BoardHistory';

const History = () => {
  const {
    homeCurrentPlayerState,
    awayCurrentPlayerState,
    isAttacking,
    log
  } = useContext(gamePlayContext)

  const playerStates = isAttacking
    ? awayCurrentPlayerState
    : homeCurrentPlayerState
  // const {playerName, uniformNumber,turn,hits,hisory} = playerStates

  // console.log(log);
  return (
    <HistoryWrap>
      <Board {...{ ...playerStates }} />
      {log.length !== 0 &&
        log.map(player => <BoardHistory key={uuidv4()} {...{ ...player }} />)}
    </HistoryWrap>
  )
}

export default History

const HistoryWrap = styled.section`
  background-color: ${({ theme }) => theme.colors.black};
  width: 20%;
`
