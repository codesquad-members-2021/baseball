import styled from 'styled-components';
import { useHistory } from 'react-router';
import { useContext } from 'react';
import { PlayableContext } from '../routes/StartScreen';

const Team = ({ type, game }) => {
  const playable = useContext(PlayableContext);
  const history = useHistory();
  const handleClickHomeTeam = () => {
    if (playable.home_team_status === true) {
      // setPlayable(playable.home_team_status === false);
      history.push('/play-screen');
    }
  };
  const handleClickAwayTeam = () => {
    if (playable.away_team_status === true) {
      // setPlayable(playable.away_team_status === false);
      history.push('/play-screen');
    }
  };

  return type === 'away' ? (
    <TeamDiv type={type} onClick={handleClickAwayTeam}>
      {game.away_team.name}
    </TeamDiv>
  ) : (
    <TeamDiv type={type} onClick={handleClickHomeTeam}>
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
