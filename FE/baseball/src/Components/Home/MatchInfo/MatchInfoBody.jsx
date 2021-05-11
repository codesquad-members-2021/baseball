import MatchBox from './MatchBox/MatchBox';
import { MatchInfo as S } from '@/Components/Home/HomeStyles';
import { v4 as uuidv4 } from 'uuid';
import useFetch from '@/customHooks/useFetch';

const MatchInfoBody = () => {
  const matchInfoData = useFetch('http://13.209.36.131:8080/main', []);

  if (!matchInfoData.games) return null;
  return (
    <S.ScrollMask>
      <S.MatchInfoBody>
        {matchInfoData.games.map((match, idx) => (
          <MatchBox key={uuidv4()} gameId={match.gameId} {...{ match, idx }} />
        ))}
      </S.MatchInfoBody>
    </S.ScrollMask>
  );
};

export default MatchInfoBody;
