import React, { useEffect, useState, useReducer } from 'react'
import Round from 'components/GamePlay/playPopUp/Round'
import Header from 'components/GamePlay/playHeader/Header'
import Main from 'components/GamePlay/playScreen/Main'
import { initialBallCount, CurrentPlayer } from 'variables/initialData'
import { ballCountReducer, playerReducer } from 'reducers/useReducers'

export const gamePlayContext = React.createContext()

const GamePlay = ({ response }) => {
  const [home, away] = response
  const [isAttacking, setIsAttacking] = useState(null)
  const [round, setRound] = useState(0)
  const [homePlayer, setHomePlayer] = useState(home.player)
  const [awayPlayer, setAwayPlayer] = useState(away.player)
  const [log, setLog] = useState([])

  const selectPitcherName = team =>
    team.player.filter(player => player.pitcher === true)[0].name

  const pitcherName = isAttacking
    ? selectPitcherName(home)
    : selectPitcherName(away)

  const [homeCurrentPlayerState, dispatchHomeCurrentPlayerState] = useReducer(
    playerReducer,
    new CurrentPlayer(
      homePlayer[0].name,
      homePlayer[0].uniform_number,
      0,
      0,
      []
    )
  )

  const [awayCurrentPlayerState, dispatchAwayCurrentPlayerState] = useReducer(
    playerReducer,
    new CurrentPlayer(
      awayPlayer[0].name,
      awayPlayer[0].uniform_number,
      0,
      0,
      []
    )
  )

  const [ballCountState, dispatchBallCount] = useReducer(
    ballCountReducer,
    initialBallCount
  )

  useEffect(() => {
    setIsAttacking(away.team_info.selected)
  }, [])

  useEffect(() => {
    if (ballCountState.S === 3) {
      dispatchBallCount({ payload: 'threeStrike', attackState: isAttacking })
    }
  }, [ballCountState.S, isAttacking])

  useEffect(() => {
    if (ballCountState.O === 3) {
      const currentPlayer = isAttacking
        ? awayCurrentPlayerState
        : homeCurrentPlayerState
      setLog(log => [...log, currentPlayer])
      setRound(round => round + 1)
      setIsAttacking(state => !state)
      dispatchBallCount({
        payload: 'resetRoundBallCount',
        attackState: isAttacking
      })
    }
  }, [ballCountState.O, isAttacking])

  useEffect(() => {
    if (ballCountState.B === 4)
      dispatchBallCount({ payload: 'runToBase', attackState: isAttacking })
  }, [ballCountState.B, isAttacking])

  return (
    <gamePlayContext.Provider
      value={{
        homeCurrentPlayerState,
        awayCurrentPlayerState,
        dispatchHomeCurrentPlayerState,
        dispatchAwayCurrentPlayerState,
        round,
        isAttacking,
        pitcherName,
        home,
        away,
        ballCountState,
        dispatchBallCount,
        log,
      }}
    >
      <Round />
      <Header />
      <Main />
    </gamePlayContext.Provider>
  )
}

export default GamePlay
