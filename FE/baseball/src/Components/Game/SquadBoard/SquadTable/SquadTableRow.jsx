import SquadTableData from "./SquadTableData";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTableRow = ({ row, isCurrentPlayer }) => {
  return row ? (
    <S.SquadTable.SquadTableRow isCurrentPlayer={isCurrentPlayer}>
      <SquadTableData data={row.타자} />
      <SquadTableData data={row.타석} />
      <SquadTableData data={row.안타} />
      <SquadTableData data={row.아웃} />
      <SquadTableData data={row.평균} />
    </S.SquadTable.SquadTableRow>
  ) : null;
};

export default SquadTableRow;
