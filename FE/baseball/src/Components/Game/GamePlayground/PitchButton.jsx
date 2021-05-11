import { GamePlayground as S } from "@/Components/Game/GameStyles";

const PitchButton = ({ dispatch }) => {
  return (
    <S.PitchButton onClick={() => dispatch({ type: "STRIKE" })}>
      Pitch
    </S.PitchButton>
  );
};

export default PitchButton;
