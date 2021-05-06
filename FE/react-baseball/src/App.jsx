import { BrowserRouter, Route, Switch } from 'react-router-dom';
import './App.css';
import PlayScreen from './routes/PlayScreen';
import StartScreen from './routes/StartScreen';

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
