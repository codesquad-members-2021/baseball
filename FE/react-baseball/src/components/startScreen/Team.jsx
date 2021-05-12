import styled from 'styled-components';
import { useHistory } from 'react-router';
import { useContext, useEffect } from 'react';
import { GlobalContext, PlayableContext } from '../../App';
import axios from 'axios';

const Team = ({ type, game }) => {
  const { setPlayable } = useContext(PlayableContext);
  const { setAwayTeam, setHomeTeam, setIsHome } = useContext(GlobalContext);
  const history = useHistory();
  const handleClickTeam = async () => {
    let teamId;
    if (type === 'home') {
      teamId = game.homeTeamId;
    } else {
      teamId = game.awayTeamId;
    }
    try {
      const { data } = await axios.get(
        `http://13.209.109.186/baseball/games/${game.gameId}/${teamId}`
      );
      const [awayInfo, homeInfo] = [data.awayTeam, data.homeTeam];
      setAwayTeam(awayInfo);
      setHomeTeam(homeInfo);
      homeInfo.userSelected && setIsHome(true);
      history.push('/play-screen');
    } catch {
      setPlayable(false);
    }
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
