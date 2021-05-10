import { MatchBox as S } from '@/Components/Home/HomeStyles';

const TeamName = ({ teamName, isPlaying }) => {
  return <S.TeamName disabled={isPlaying}>{teamName}</S.TeamName>;
};

export default TeamName;
