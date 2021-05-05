import GameHeader from "./GameHeader/GameHeader";
import GamePlayground from "./GamePlayground/GamePlayground";
import { Game as SGame } from "@/Components/Game/GameStyles";

const Game = () => {
  return (
    <SGame>
      <GameHeader />
      <GamePlayground />
    </SGame>
  );
};

export { Game };
