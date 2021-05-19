import { useContext, useState } from 'react';
import styled from 'styled-components';

import FlexCenter from 'styles/FlexCenter';
import Span from 'components/common/Span';
import VsSpan from 'components/common/VsSpan';

import { gamePlayContext } from 'components/GamePlay/GamePlay';

const HeaderScore = () => {
  const { home, away } = useContext(gamePlayContext);
  const homeTeam = home.team_info;
  const awayTeam = away.team_info;
  // 함수 GAME에서 넘겨줘야함

  const [scores, setScores] = useState({ home: 0, away: 0 });

  return (
    <GameScoreWrap>
      <Span selected={homeTeam.selected}>{homeTeam.team_name}</Span>
      <Span>{scores.home}</Span>
      <VsSpan>vs</VsSpan>
      <Span>{scores.away}</Span>
      <Span selected={awayTeam.selected}>{awayTeam.team_name}</Span>
    </GameScoreWrap>
  );
};

export default HeaderScore;

const GameScoreWrap = styled(FlexCenter)`
  justify-content: space-between;
  width: 100%;
  padding: 0.5rem 7rem;
`;
