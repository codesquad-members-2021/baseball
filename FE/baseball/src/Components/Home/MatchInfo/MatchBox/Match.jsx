import { Link } from 'react-router-dom';
import TeamName from './TeamName';
import VS from './VS';
import { MatchBox as S } from '@/Components/Home/HomeStyles';

const Match = () => {
  return (
    <S.Match>
      <S.Link>
        <Link to="/game">
          <TeamName />
        </Link>
      </S.Link>
      <VS />
      <S.Link>
        <Link to="/game">
          <TeamName />
        </Link>
      </S.Link>
    </S.Match>
  );
};

export default Match;
