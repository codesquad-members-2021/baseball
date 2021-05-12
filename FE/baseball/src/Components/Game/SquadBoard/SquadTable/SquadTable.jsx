import SquadTableHeader from "./SquadTableHeader";
import SquadTableBody from "./SquadTableBody";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTable = ({ teamName, selectedTeam, isDefenseTeam, squads }) => {
  let currentPlayerNumber = 3;

  const newSquads = squads.map((v, index) => {
    if (isDefenseTeam === teamName) {
      // 수비팀일 경우 투수를 하이라이트
      if (v.position === "pitcher") {
        return { ...v, isCurrentPlayer: true };
      } else {
        return { ...v, isCurrentPlayer: false };
      }
    } else {
      // 공격팀일 경우 타자를 하이라이트
      if (index === currentPlayerNumber - 1) {
        return { ...v, isCurrentPlayer: true };
      } else {
        return { ...v, isCurrentPlayer: false };
      }
    }
  });

  return (
    <S.SquadTable.SquadTable>
      <SquadTableHeader teamName={teamName} selectedTeam={selectedTeam} />
      <SquadTableBody squads={newSquads} />
    </S.SquadTable.SquadTable>
  );
};

export default SquadTable;
