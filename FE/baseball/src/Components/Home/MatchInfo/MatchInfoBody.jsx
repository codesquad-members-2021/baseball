import MatchBox from './MatchBox/MatchBox';
import { MatchInfo as S } from '@/Components/Home/HomeStyles';
import { matchInfoData } from './temp_matchInfoData';
import { v4 as uuidv4 } from 'uuid';

const MatchInfoBody = () => {
  return (
    <S.ScrollMask>
      <S.MatchInfoBody>
        {matchInfoData.game.map((match, idx) => (
          <MatchBox key={uuidv4()} gameId={match.gameId} {...{ match, idx }} />
        ))}
      </S.MatchInfoBody>
    </S.ScrollMask>
  );
};

export default MatchInfoBody;
