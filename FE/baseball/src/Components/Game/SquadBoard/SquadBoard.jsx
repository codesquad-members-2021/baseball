import { useState, useContext } from "react";
import { GameContext } from "@/Components/Game/Game";
import PopUpButton from "./PopUpButton";
import SquadTable from "./SquadTable/SquadTable";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadBoard = () => {
  const {
    squadMockData,
    gameMockData: { game },
    selectedTeam,
  } = useContext(GameContext);

  const [mouseOverFlag, setMouseOverFlag] = useState(false);

  const handleMouseOver = ({ target: { tagName } }) => {
    if (tagName === "path" || tagName === "svg") return;
    setMouseOverFlag((prev) => !prev);
  };

  return (
    <S.SquadBoardWrapper>
      <S.PopUpBackground isMouseOver={mouseOverFlag} />
      <PopUpButton handleMouseOver={handleMouseOver} />
      <S.SquadBoard isMouseOver={mouseOverFlag} onMouseLeave={handleMouseOver}>
        <SquadTable
          teamName={game.away.teamName}
          squads={squadMockData.away}
          isDefenseTeam={squadMockData.defenseTeam}
          selectedTeam={selectedTeam}
        />
        <SquadTable
          teamName={game.home.teamName}
          squads={squadMockData.home}
          isDefenseTeam={squadMockData.defenseTeam}
          selectedTeam={selectedTeam}
        />
      </S.SquadBoard>
    </S.SquadBoardWrapper>
  );
};

export default SquadBoard;
