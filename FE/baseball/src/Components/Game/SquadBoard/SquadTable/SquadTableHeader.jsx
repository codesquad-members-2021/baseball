import CurrentPlayerTag from "./CurrentPlayerTag";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTableHeader = ({ teamName, selectedTeam }) => {
  return (
    <>
      <S.SquadTable.SquadTableHeader>
        {teamName}
        {teamName === selectedTeam ? <CurrentPlayerTag /> : null}
      </S.SquadTable.SquadTableHeader>
    </>
  );
};

export default SquadTableHeader;
