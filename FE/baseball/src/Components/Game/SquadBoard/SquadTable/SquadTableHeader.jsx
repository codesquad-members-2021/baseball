import CurrentPlayerTag from "./CurrentPlayerTag";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTableHeader = ({ teamName, isCurrentPlayer }) => {
  return (
    <>
      <S.SquadTable.SquadTableHeader>
        {teamName}
        {isCurrentPlayer ? <CurrentPlayerTag /> : null}
      </S.SquadTable.SquadTableHeader>
    </>
  );
};

export default SquadTableHeader;
