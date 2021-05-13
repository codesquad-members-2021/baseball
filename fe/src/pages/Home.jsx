import GameContainer from 'components/GameHome/GameContainer';
import styled from 'styled-components';

const Home = () => {
  return (
    <Main>
      <GameContainer />
    </Main>
  );
};

export default Home;

const Main = styled.main`
  margin: 0 auto;
  width: 100%;
  height: 100vh;
  display: flex;
  justify-content: center;
  background-image: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
    url('https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png');
  background-repeat: no-repeat;
  background-size: cover;
  z-index: -1;
`;
