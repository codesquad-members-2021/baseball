import { ScoreBoardStyles as S } from '@/Components/Game/ScoreBoard/ScoreBoardStyles';
import { BLANK } from '@/Utils/const';

const AttackTeamTag = ({ isOffense }) => {
  return <S.AttackTeamTag>{isOffense ? `⚾︎` : BLANK}</S.AttackTeamTag>;
};

export default AttackTeamTag;
