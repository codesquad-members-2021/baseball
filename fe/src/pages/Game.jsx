import React, { useEffect, useState, useReducer } from 'react'
import useFetch from 'hooks/useFetch'
import Header from 'components/GamePlay/playHeader/Header'
import Main from 'components/GamePlay/playScreen/Main'
import PopUp from 'components/GamePlay/playPopUp/PopUp'
import qs from 'qs'
// 쿼리값 읽고 데이터 페치 받은다음에 뿌려준다.
export const gamePlayContext = React.createContext()

const Game = () => {
  const { team } = qs.parse(window.location.search, {
    ignoreQueryPrefix: true
  })

  const { response, loading, error } = useFetch(
    process.env.REACT_APP_API_URL + `select_team/${team}`
  )
  const [isAttacking, setIsAttacking] = useState(null)
  // const [homePrevPlayer, setHomePrevPlayer] = useState({});
  // const [awayPrevPlayer, setAwayPrevPlayer] = useState([{}]);

  const getDeepCopy = original => JSON.parse(JSON.stringify(original))

  const ballCountReducer = (state, action) => {
    const deepCopied = getDeepCopy(state)
    deepCopied.count += 1

    switch (action.payload) {
      case 'strike':
        deepCopied.s += 1
        deepCopied.type = '스트라이크'
        return deepCopied
      case 'ball':
        deepCopied.b += 1
        deepCopied.type = '볼'
        return deepCopied
      case 'out':
        deepCopied.o += 1
        deepCopied.type = '아웃'
        return deepCopied
      case 'hit':
        deepCopied.isHit = true
        deepCopied.type = '안타'
        return deepCopied
      default:
    }
  }

  const initialBallCount = {
    count: 0,
    type: '스트라이크',
    s: 0,
    b: 0,
    o: 0,
    isHit: false
  }

  const [ballCountState, dispatchBallCount] = useReducer(
    ballCountReducer,
    initialBallCount
  )

  const [currentPlayer, setCurrentPlayer] = useState({
    playerName: '류현진',
    uniform_number: 2,
    turn: 1,
    hit: 0,
    history: [ballCountState]
  })

 
  // useEffect(() => {}, [ballCount]);

  // useEffect(() => {}, [out]);
  const setInitialAttackTurn = away => {
    if (isAttacking === null) setIsAttacking(away.team_info.selected)
    else return
  }

  if (loading) return <div>loading</div>

  const [home, away] = response
  setInitialAttackTurn(away)

  const selectPitcherName = team =>
    team.player.filter(player => player.pitcher === true)[0].name

  const pitcherName = isAttacking
    ? selectPitcherName(home)
    : selectPitcherName(away)

  return (
    <gamePlayContext.Provider
      value={{
        isAttacking,
        pitcherName,
        home,
        away,
        ballCountState,
        dispatchBallCount
      }}
    >
      <PopUp type="down"><div style={{color:"white",background:'red',margin:"1rem", marginTop:"3rem"}}>요호</div></PopUp>
      <Header />
      <Main />
    </gamePlayContext.Provider>
  )
}

export default Game
