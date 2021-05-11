import { useState, useContext } from "react";
import { GameContext } from "@/Components/Game/Game";
import PopUpButton from "./PopUpButton";
import SquadTable from "./SquadTable/SquadTable";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadBoard = () => {
  const { gameData, squadMockData, teamName } = useContext(GameContext);

  const [mouseOverFlag, setMouseOverFlag] = useState(false);

  const handleMouseOver = ({ target: { tagName } }) => {
    if (tagName === "path" || tagName === "svg") return;
    setMouseOverFlag((prev) => !prev);
  };

  return gameData ? (
    <S.SquadBoardWrapper>
      <S.PopUpBackground isMouseOver={mouseOverFlag} />
      <PopUpButton handleMouseOver={handleMouseOver} />
      <S.SquadBoard isMouseOver={mouseOverFlag} onMouseLeave={handleMouseOver}>
        <SquadTable
          teamName={gameData.away.teamName}
          squads={squadMockData.away}
          isDefenseTeam={squadMockData.defenseTeam}
          selectedTeam={teamName}
        />
        <SquadTable
          teamName={gameData.home.teamName}
          squads={squadMockData.home}
          isDefenseTeam={squadMockData.defenseTeam}
          selectedTeam={teamName}
        />
      </S.SquadBoard>
    </S.SquadBoardWrapper>
  ) : null;
};

export default SquadBoard;
