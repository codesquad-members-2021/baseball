import { createContext } from 'react';
import Caption from '../components/Caption';
import GameList from '../components/GameList';
import Title from '../components/Title';
import styled from 'styled-components';

const playable = {
  // 임시 데이터
  id: 1,
  away_team_status: true,
  home_team_status: false,
};
// const [playable, setPlayable]
// const [clicked, setClicked] 팀 클릭했을 때 홈, 원정 어떤게 선택됐는지 저장
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
