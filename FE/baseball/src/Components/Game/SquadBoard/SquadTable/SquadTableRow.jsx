import SquadTableData from "./SquadTableData";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTableRow = ({ row }) => {
  return row ? (
    <S.SquadTable.SquadTableRow isCurrentPlayer={row.isCurrentPlayer}>
      <SquadTableData data={row.player} />
      <SquadTableData data={row.pa} />
      <SquadTableData data={row.hit} />
      <SquadTableData data={row.out} />
      {typeof row.average === "number" ? (
        <SquadTableData data={row.average.toFixed(3)} />
      ) : (
        <SquadTableData data={row.average} />
      )}
    </S.SquadTable.SquadTableRow>
  ) : null;
};

export default SquadTableRow;

/*
현재 선수인것은 어떻게 알 수 있을까?
-> 첫번째 부터 선수를 돌릴 건데 , 돌릴때 해당 인덱스의 선수가 현재 선수이다.
현재 선수 정보로 Log도 만들어줘야하고, 하이라이트도 곳곳에 주어야 한다.
결국 game에서 관리되어야 할 상태일 것이다.
game에서 context로 isCurrentPlayer라는 정보가 올 것이다.
그 정보를 어떻게 한 선수의 dashBoard에 row에 줄 수 있을까?
squadData를 받아오고 나서, 현재 선수한테 isCurrentPlayer를 true로 주고 나머지는 false로 주면 될 것 같다.

table이 공격 table일 경우는 타자를 하이라이트 해준다.
수비일때는 투수를 하이라이트 해준다.
*/
