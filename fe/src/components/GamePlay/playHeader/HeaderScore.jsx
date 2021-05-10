import { useContext, useState } from 'react';
import { gamePlayContext } from 'pages/Game';
import styled from 'styled-components';
import Span from 'components/common/Span';
import VsSpan from 'components/common/VsSpan';
import FlexCenter from 'styles/FlexCenter';

const HeaderScore = () => {
  const { home, away } = useContext(gamePlayContext);
  const [scores, setScores] = useState({ home: 0, away: 0 });
  return (
    <GameScoreWrap>
      <Span selected={home.selected}>{home.teamName}</Span>
      <Span>{scores.home}</Span>
      <VsSpan>vs</VsSpan>
      <Span>{scores.away}</Span>
      <Span selected={away.selected}>{away.teamName}</Span>
    </GameScoreWrap>
  );
};

export default HeaderScore;

const GameScoreWrap = styled(FlexCenter)`
  justify-content: space-between;
  width: 100%;
  padding: 0.5rem 7rem;
`;
