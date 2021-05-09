import { createContext } from 'react';
import Caption from '../components/Caption';
import GameList from '../components/GameList';
import Title from '../components/Title';
import styled from 'styled-components';

const playable = {
  // 임시 데이터
  id: 1,
  home_team_status: true,
  away_team_status: true,
};

export const PlayableContext = createContext();

const StartScreen = (props) => {
  return (
    <PlayableContext.Provider value={playable}>
      <StartDiv>
        <Title />
        <Caption />
        <GameList />
      </StartDiv>
    </PlayableContext.Provider>
  );
};

const StartDiv = styled.div`
  margin: 0 auto;
  max-width: 1440px;
  display: flex;
  align-items: center;
  flex-direction: column;
`;

export default StartScreen;
