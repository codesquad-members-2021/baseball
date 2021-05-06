import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import PlayScreen from './components/PlayScreen';
import StartScreen from './components/StartScreen';

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <StartScreen />
        </Route>
        <Route path="/play-screen">
          <PlayScreen />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
