import { GameHeader as S } from "@/Components/Game/GameStyles";

const Score = ({ score }) => {
  return <S.GameProgress.Score>{score}</S.GameProgress.Score>;
};

export default Score;
