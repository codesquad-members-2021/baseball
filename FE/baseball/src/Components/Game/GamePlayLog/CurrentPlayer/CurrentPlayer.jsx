import PlayerBox from "./PlayerBox";
import { GamePlayLog as S } from "@/Components/Game/GameStyles";

const CurrentPlayer = ({ currentPlayer }) => {
  return (
    <S.CurrentPlayer.CurrentPlayer>
      {/* playerBox에는 선수이름,포지션,투구갯수 or 타석/안타 정보가 props로 내려질 예정입니다.*/}
      <PlayerBox />
      <PlayerBox />
    </S.CurrentPlayer.CurrentPlayer>
  );
};

export default CurrentPlayer;
