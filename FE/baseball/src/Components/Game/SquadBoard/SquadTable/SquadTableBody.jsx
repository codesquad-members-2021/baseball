import SquadTableRow from "./SquadTableRow";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTableBody = ({ playerInfo }) => {
  const rowHeaderDefault = {
    타자: "타자",
    타석: "타석",
    안타: "안타",
    아웃: "아웃",
    평균: "평균",
  };
  const mockRow = {
    타자: "스윙",
    타석: "1",
    안타: "2",
    아웃: "2",
    평균: "1.000",
  };
  return (
    <S.SquadTable.SquadTableBody>
      <tbody>
        <SquadTableRow row={rowHeaderDefault} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
        <SquadTableRow row={mockRow} />
      </tbody>
    </S.SquadTable.SquadTableBody>
  );
};

export default SquadTableBody;
