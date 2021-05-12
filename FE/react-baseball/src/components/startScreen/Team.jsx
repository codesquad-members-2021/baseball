import styled from 'styled-components';
import { useHistory } from 'react-router';
import { useContext } from 'react';
import { GlobalContext, PlayableContext } from '../../App';
import axios from 'axios';

const Team = ({ type, game }) => {
  const { setPlayable } = useContext(PlayableContext);
  const { setMyTeam, setCounterTeam, isHome, setIsHome, setIsDefense } =
    useContext(GlobalContext);
  const history = useHistory();
  const handleClickTeam = async () => {
    // 서버에 gameId 담아 POST 요청
    // 200 OK 시, 응답 받은 데이터를 context에 세팅 (?) (then 또는 await)
    const { data } = await axios.get('http://localhost:3000/players-modi.json');
    const [awayInfo, homeInfo] = [data.awayTeam, data.homeTeam];
    homeInfo.userSelected && setIsHome(true);
    if (isHome) {
      setMyTeam(homeInfo.players);
      setCounterTeam(awayInfo.players);
      setIsDefense(isHome);
    } else {
      setMyTeam(awayInfo.players);
      setCounterTeam(homeInfo.players);
    }

    // 그리고 '/play-screen' 으로 라우팅
    history.push('/play-screen');
    // 에러 시, Caption의 메시지를 바꿔줌
    setPlayable(false);
  };

  return type === 'away' ? (
    <TeamDiv type={type} onClick={handleClickTeam}>
      {game.awayTeamName}
    </TeamDiv>
  ) : (
    <TeamDiv type={type} onClick={handleClickTeam}>
      {game.homeTeamName}
    </TeamDiv>
  );
};

const TeamDiv = styled.div`
  /* font-size: ${({ theme }) => theme.fontSizes.XL}; */
  font-size: 32px;
  font-weight: bold;
  color: ${({ theme }) => theme.colors.darkGray};
  width: 180px;
  text-align: ${({ type }) => (type === 'home' ? 'left' : 'right')};

  &:hover {
    cursor: pointer;
    color: ${({ theme }) => theme.colors.green};
  }
`;

export default Team;
