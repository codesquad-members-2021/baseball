import styled from 'styled-components';
import GameList from './components/game-list/GameList';
import GamePlay from './components/game-play/GamePlay';
import background from './images/background.png';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

function App() {
  return (
    <Router>
      <StyledBackground src={background}></StyledBackground>
      <Route exact={true} path='/'>
        <GameList />
      </Route>
      <Route path='/games'>
        <GamePlay />
      </Route>
    </Router>
  );
}

const StyledBackground = styled.div`
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

const DATA_LIST_URL = 'http://52.78.184.142/games';
