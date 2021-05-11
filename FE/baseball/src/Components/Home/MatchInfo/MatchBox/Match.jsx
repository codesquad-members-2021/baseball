import { Link } from 'react-router-dom';
import TeamName from './TeamName';
import VS from './VS';
import { MatchBox as S } from '@/Components/Home/HomeStyles';

const Match = ({ gameId, match }) => {
  return (
    <S.Match>
      <S.Link>
        <Link
          to={{
            pathname: '/game',
            state: {
              gameId: gameId,
              teamName: match.away.teamName,
            },
          }}
        >
          <TeamName
            teamName={match.away.teamName}
            isPlaying={match.away.isPlaying}
          />
        </Link>
      </S.Link>
      <VS />
      <S.Link>
        <Link
          to={{
            pathname: '/game',
            state: {
              gameId: gameId,
              teamName: match.home.teamName,
            },
          }}
        >
          <TeamName
            teamName={match.home.teamName}
            isPlaying={match.home.isPlaying}
          />
        </Link>
      </S.Link>
    </S.Match>
  );
};

export default Match;
