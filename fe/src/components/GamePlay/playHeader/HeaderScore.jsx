import { useContext, useState } from 'react'
import { gamePlayContext } from 'pages/Game'
import styled from 'styled-components'
import Span from 'components/common/Span'
import FlexCenter from 'styles/FlexCenter'

const HeaderScore = () => {
  const { home, away } = useContext(gamePlayContext)
  const [scores, setScores] = useState({ home: 0, away: 0 })
  return (
    <GameScoreWrap>
      <Span size={4} selected={home.selected}>
        {home.teamName}
      </Span>
      <Span size={4}>{scores.home}</Span>
      <Span size={2}>vs</Span>
      <Span size={4}>{scores.away}</Span>
      <Span size={4} selected={away.selected}>
        {away.teamName}
      </Span>
    </GameScoreWrap>
  )
}

export default HeaderScore

const GameScoreWrap = styled(FlexCenter)`
  justify-content: space-between;
  width: 100%;
  padding : 0.5rem 6rem;
`