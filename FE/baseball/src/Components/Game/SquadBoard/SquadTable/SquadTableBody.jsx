import SquadTableRow from "./SquadTableRow";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTableBody = ({ squads }) => {
  const rowHeaderDefault = {
    player: "player",
    pa: "pa",
    hit: "hit",
    out: "out",
    average: "average",
  };

  const total = {
    player: "Totals",
    pa: squads.reduce((prev, curr) => prev + curr.pa, 0),
    hit: squads.reduce((prev, curr) => prev + curr.hit, 0),
    out: squads.reduce((prev, curr) => prev + curr.out, 0),
    average: "------",
  };

  return (
    <S.SquadTable.SquadTableBody>
      <tbody>
        <SquadTableRow row={rowHeaderDefault} />
        {squads.map((playerInfo, index) => {
          return <SquadTableRow key={index} row={playerInfo} />;
        })}
        <SquadTableRow row={total} />
      </tbody>
    </S.SquadTable.SquadTableBody>
  );
};

export default SquadTableBody;
