import styled from 'styled-components';
import { useHistory } from 'react-router';

const Team = ({ type, game }) => {
  const history = useHistory();
  const handleClickTeam = () => history.push('/play-screen');
  // 클릭하면 GET /games/{gameId} 요청 보내서
  // 입장 가능한 게임인지 데이터를 받아오고, 상태를 set한다.

  return type === 'home' ? (
    <TeamDiv type={type} onClick={handleClickTeam}>
      {game.home_team.name}
    </TeamDiv>
  ) : (
    <TeamDiv type={type} onClick={handleClickTeam}>
      {game.away_team.name}
    </TeamDiv>
  );
};

const TeamDiv = styled.div`
  /* font-size: ${({ theme }) => theme.fontSizes.XL}; */
  font-size: 32px;
  font-weight: bold;
  color: ${({ theme }) => theme.colors.darkGray};
  width: 180px;
  text-align: ${({ type }) => (type === 'home' ? 'right' : 'left')};

  &:hover {
    cursor: pointer;
    color: ${({ theme }) => theme.colors.green};
  }
`;

export default Team;
