import { useState } from "react";
import PopUpButton from "./PopUpButton";
import SquadTable from "./SquadTable/SquadTable";
import { SquadBoard as S } from "@/Components/Game/GameStyles";

const SquadBoard = () => {
  const [mouseOverFlag, setMouseOverFlag] = useState(false);

  const handleMouseOver = ({ target: { tagName } }) => {
    if (tagName === "path" || tagName === "svg") return;
    setMouseOverFlag((prev) => !prev);
  };

  return (
    <>
      <S.SquadBoardWrapper>
        <S.PopUpBackground
          isMouseOver={mouseOverFlag}
          onMouseOver={handleMouseOver}
        />
        <PopUpButton handleMouseOver={handleMouseOver} />
        <S.SquadBoard isMouseOver={mouseOverFlag}>
          <SquadTable />
          <SquadTable />
        </S.SquadBoard>
      </S.SquadBoardWrapper>
    </>
  );
};

export default SquadBoard;
