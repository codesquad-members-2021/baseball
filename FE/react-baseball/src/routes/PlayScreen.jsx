import styled from 'styled-components';
import Score from '../components/playScreen/Score';
import LogList from '../components/playScreen/LogList';
import Stadium from '../components/playScreen/Stadium';
import CurrentPlayer from '../components/playScreen/CurrentPlayer';

const PlayScreen = (props) => (
  <PlayScreenDiv>
    <Score />
    <CurrentPlayer />
    <Stadium />
    <LogList />
  </PlayScreenDiv>
);

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
