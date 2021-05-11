import { GamePlayground as S } from "@/Components/Game/GameStyles";

const PitchButton = () => {
  const test = () => {
    console.log("pitched!");
  };
  return <S.PitchButton onClick={test}>Pitch</S.PitchButton>;
};

export default PitchButton;
