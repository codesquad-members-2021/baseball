import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadTableHeader = ({ teamName }) => {
  return (
    <S.SquadTable.SquadTableHeader>{teamName}</S.SquadTable.SquadTableHeader>
  );
};

export default SquadTableHeader;
