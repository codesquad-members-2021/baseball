import styled from 'styled-components';
import Score from '../components/playScreen/Score';
import LogList from '../components/playScreen/LogList';
import Stadium from '../components/playScreen/Stadium';
import CurrentPlayer from '../components/playScreen/CurrentPlayer';
import { useEffect, useContext } from 'react';
import { GlobalContext } from '../App';

const PlayScreen = (props) => {
  const {
    isHome,
    homeTeam,
    awayTeam,
    setMyTeam,
    setMyTeamName,
    setCounterTeam,
    setCounterTeamName,
    setCurrHitter,
  } = useContext(GlobalContext);

  useEffect(() => setCurrHitter(awayTeam.players[0]), []);

  if (isHome) {
    setMyTeam(homeTeam.players);
    setMyTeamName(homeTeam.teamName);
    setCounterTeam(awayTeam.players);
    setCounterTeamName(awayTeam.teamName);
  } else {
    setMyTeam(awayTeam.players);
    setMyTeamName(awayTeam.teamName);
    setCounterTeam(homeTeam.players);
    setCounterTeamName(homeTeam.teamName);
  }
  return (
    <PlayScreenDiv>
      <Score />
      <CurrentPlayer />
      <Stadium />
      <LogList />
    </PlayScreenDiv>
  );
};

const PlayScreenDiv = styled.div`
  display: grid;
  grid-template-columns: 1100px 300px;
  grid-template-rows: 200px 600px;
  width: 1400px;
  height: 800px;
  border: 0.5rem outset #ffffff;
  border-radius: 12px;
  outline-offset: 0.5rem;
`;

export default PlayScreen;
