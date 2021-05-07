import styled from 'styled-components';
import GameList from './components/game-list/GameList';
import GamePlay from './components/game-play/GamePlay';
import background from './images/background.png';

function App() {
  return (
    <>
      <StyleBackground src={background}></StyleBackground>
      {/* <GameList /> */}
      <GamePlay />
    </>
  );
}

const StyleBackground = styled.div`
  background-image: url(${(props) => props.src});
  background-size: cover;
  position: absolute;
  top: 0;
  width: 100vw;
  height: 100vh;
  z-index: -1;
  &:before {
    background-color: rgba(0, 0, 0, 0.8);
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    z-index: -1;
  }
`;

export default App;
