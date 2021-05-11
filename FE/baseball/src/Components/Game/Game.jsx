
import React, { useContext } from "react";
import GameHeader from './GameHeader/GameHeader';
import GamePlayground from './GamePlayground/GamePlayground';
import GamePlayLog from './GamePlayLog/GamePlayLog';
import SquadBoard from './SquadBoard/SquadBoard';
import ScoreBoard from './ScoreBoard/ScoreBoard';
import { gameMockData, squadMockData } from '@/Utils/mockData';
import { Game as S } from '@/Components/Game/GameStyles';
import { BACKGROUND_URL } from '@/Utils/const';
import { RouterContext } from "@/Routes/Router";



const GameContext = React.createContext();

const Game = ({ location }) => {
    const { gameData, selectedTeam } = useContext(RouterContext);
  
  const gameData = location.state;
  const { gameId, teamName } = gameData;
  console.log(gameId, teamName);
  // 팀네임을 눌렀을때 isSelected를 넘겨주면 되는데...
  // 아마 눌리는 이벤트에 dispatch를 걸어서 메시지에 game_id랑 SelectedTeam을 주면 될 것 같다 !
  // 그럼 game_id를 받아와서 데이터 패칭하고, SelectedTeam정보를 progress까지 내려주면 될 것 같다 !
  // const [data,setData] = useState(null);
  // setData(game_id)

  // 추후 받아온 셀렉팀 네임을 내려줄 예정
  // const selectedTeam = 'Marvel';
  const selectedTeam = teamName;

  // 셀렉팀을 무조건 먼저 수비로 두자. (1회초 수비)
  // 아웃 3카운트 이후 데이터를 받아올때 defenseTeam을 바꿔주자.
  
  // 선택한 팀을 먼저 수비로 지정한다.
  // 추후 아웃 3카운트 이후 데이터를 받아올때 defenseTeam을 바꿔줄 예정
  squadMockData.defenseTeam = selectedTeam;

  return (
    <GameContext.Provider value={{ gameMockData, squadMockData, selectedTeam }}>
      <S.Background src={BACKGROUND_URL} />
      <S.Game>
        <S.GameLeftSection>
          <GameHeader />
          <GamePlayground />
        </S.GameLeftSection>
        <S.GameRightSection>
          <GamePlayLog />
        </S.GameRightSection>
        <ScoreBoard />
        <SquadBoard />
      </S.Game>
    </GameContext.Provider>
  );
};

export { Game, GameContext };
