import { useContext } from 'react'
import styled from 'styled-components'
import { Link } from 'react-router-dom'
import Span from 'components/common/Span'
import FlexCenter from 'styles/FlexCenter'
import {GameItemContext} from 'components/GameHome/GameItem'
import {GameContext} from 'components/GameHome/GameContainer'

const TeamName = ({ type }) => {
  const { isStart, home, away } = useContext(GameItemContext)
  const {changeNotice} = useContext(GameContext);
  const pathFinder = type => {
    return {
      pathname: '/game',
      search: `team=${type === 'home' ? home : away }`
    }
  }
  return (
    <TeamNameWrap>
      {isStart ? (
        <Link to='' onClick={changeNotice}>
          <Span size={3} weight={600}>
            {type === 'home' ? home : away}
          </Span>
        </Link>
      ) : (
        <Link to={pathFinder(type)}>
          <Span size={3} weight={600}>
            {type === 'home' ? home : away}
          </Span>
        </Link>
      )}
    </TeamNameWrap>
  )
}

export default TeamName


const TeamNameWrap = styled(FlexCenter)`
  width: 40%;
  &:hover {
    color: red;
    cursor: pointer;
  }
`

