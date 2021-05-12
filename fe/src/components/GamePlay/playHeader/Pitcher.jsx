import { useContext, useState, useEffect } from 'react'
import { gamePlayContext } from 'pages/Game'

const Pitcher = ({ pitcher }) => {
  const { ballCountState, pitcherName, isAttacking } = useContext(
    gamePlayContext
  )
  const [homeCount, setHomeCount] = useState(0)
  const [awayCount, setAwayCount] = useState(0)
  let type = isAttacking ? 'away' : 'home'

  useEffect(() => {
    if (isAttacking) return setAwayCount(count => count + ballCountState.count)
    setHomeCount(count => count + ballCountState.count)
  }, [isAttacking])

  return (
    <>
      <span>{pitcherName}</span>
      {isAttacking ? (
        <span># {ballCountState.count + awayCount}</span>
      ) : (
        <span># {ballCountState.count + homeCount}</span>
      )}
    </>
  )
}

export default Pitcher
