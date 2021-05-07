import SquadTableHeader from "./SquadTableHeader";
import SquadTableBody from "./SquadTableBody";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTable = () => {
  return (
    <S.SquadTable.SquadTable>
      <SquadTableHeader teamName={"TEAM - ILLY"} isCurrentPlayer={true} />
      <SquadTableBody />
    </S.SquadTable.SquadTable>
  );
};

export default SquadTable;
