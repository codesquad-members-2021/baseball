import { useContext } from "react";
import { GameContext } from "@/Components/Game/Game";
import Score from "./Score";
import TeamName from "./TeamName";
import VS from "./VS";
import { GameHeader as S } from "@/Components/Game/GameStyles";

const GameProgress = () => {
  const {
    gameMockData: { game },
    selectedTeam,
  } = useContext(GameContext);

  return (
    <S.GameProgress.GameProgress>
      <TeamName teamName={game.away.teamName} selectedTeam={selectedTeam} />
      <Score score={1} />
      <VS />
      <Score score={5} />
      <TeamName teamName={game.home.teamName} selectedTeam={selectedTeam} />
    </S.GameProgress.GameProgress>
  );
};

export default GameProgress;
