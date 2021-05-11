import styled from 'styled-components';
import { useHistory } from 'react-router';
import { useContext } from 'react';
import { PlayableContext } from '../../App';

const Team = ({ type, game }) => {
  const { playable, setPlayable } = useContext(PlayableContext);
  const history = useHistory();
  const handleClickTeam = () => {
    // 서버에 gameId 담아 POST 요청
    // 200 OK 시, 응답 받은 데이터를 context에 세팅 (?) (then 또는 await)
    // 그리고 '/play-screen' 으로 라우팅
    // history.push('/play-screen');
    // 에러 시, Caption의 메시지를 바꿔줌
    setPlayable(false);
  };

  return type === 'away' ? (
    <TeamDiv type={type} onClick={handleClickTeam}>
      {game.away_team.name}
    </TeamDiv>
  ) : (
    <TeamDiv type={type} onClick={handleClickTeam}>
      {game.home_team.name}
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
