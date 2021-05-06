import { HomeStyles as S } from '@/Components/Home/HomeStyles';
import TeamName from './TeamName';
import VS from './VS';

const Match = () => {
  return (
    <S.Match>
      <TeamName />
      <VS />
      <TeamName />
    </S.Match>
  );
};

export default Match;
