import GameHeader from "./GameHeader/GameHeader";
import GamePlayground from "./GamePlayground/GamePlayground";
import GamePlayLog from "./GamePlayLog/GamePlayLog";
import SquadBoard from "./SquadBoard/SquadBoard";
import ScoreBoard from "./ScoreBoard/ScoreBoard";
import { Game as S } from "@/Components/Game/GameStyles";

const Game = () => {
  const backgroundUrl =
    "https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png";
  return (
    <>
      <S.Background src={backgroundUrl} />
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
    </>
  );
};

export { Game };

/*
## 프로젝트 2주차 Task

- 화면 상단에 현재 팀 정보 (팀 네임) 와 스코어 가 나와야한다.
- 앞서 클릭한 팀 네임에 현재 내가 플레이한 팀임을 알 수 있는 flag를 준다. (reducer로 메시지를 주어야 할 듯 ex. dispatch({isClicked : true})
- 스트라이크 , 볼 , 아웃에 따라 볼 보드를 최신화 시켜준다.
- 주자 진루 알고리즘에 따라 애니메이션을 준다.
- [Pitch] 버튼을 누르면 스트라이크 , 볼 , 안타 중에 랜덤한 액션을 보낸다.
- 버튼을 누르면 pitch 카운트가 올라가며, 액션 로그에 기록된다.
- 액션 로그에서 현재 선수는 하이라이트를 준다.
- 선수 로그에는 현재 투수의 이름과 투구갯수 , 현재 타자의 이름과 타석, 안타가 나온다.
- 공격 상황일때는 몇초 간격으로 게임이 진행되는 것처럼 pitch를 누를때와 동일한 액션을 준다.
- 하단 팝업에는 팀 정보가 나온다. (선수들의 정보가 받아질 예정 , 토탈은 따로 해주어야 함)
- 현재 선수에 하이라이트를 주어야 한다.

## 주자 진루 알고리즘

### 진루 현황

1. 주자가 없을 때
2. 주자가 1루에 있을 때
3. 주자가 1,2루에 있을 때
4. 주자가 1,3루에 있을 때
5. 주자가 1,2,3루에 있을 때
6. 주자가 2루에 있을 때
7. 주자가 2,3루에 있을 때
8. 주자가 3루에 있을 때

### 출루 액션

1. 1루타 (볼넷 포함)
2. 2루타
3. 3루타
4. 홈런

총 32개의 시나리오가 있음
*/
