import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';

const ScoreItem = ({ inningScore, inning, idx, totalScore }) => {
  let number = inningScore || inning;
  if (inningScore === 0) number = 0;
  if (idx === 12) number = totalScore;

  return <S.ScoreItem>{number}</S.ScoreItem>;
};

export default ScoreItem;
