import { useState } from "react";
import PopUpButton from "./PopUpButton";
import SquadTable from "./SquadTable/SquadTable";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadBoard = () => {
  const [mouseOverFlag, setMouseOverFlag] = useState(false);

  const handleMouseOver = () => {
    setMouseOverFlag((prev) => !prev);
    console.log("화면이 보여지나요 ? " + mouseOverFlag);
  };

  return (
    <>
      <S.PopUpBackground isMouseOver={mouseOverFlag} />
      <PopUpButton
        isMouseOver={mouseOverFlag}
        handleMouseOver={handleMouseOver}
      />
      <S.SquadBoard isMouseOver={mouseOverFlag}>
        <SquadTable />
      </S.SquadBoard>
    </>
  );
};

export default SquadBoard;
