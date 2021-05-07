import GlobalStyle from './components/Style/GlobalStyle';
import StartPage from './components/StartPage';
import AttackMode from './components/AttackMode';
import DefenseMode from './components/DefenseMode';
import { BrowserRouter, Switch, Route } from 'react-router-dom';

function App() {
  return (
    <BrowserRouter>
      <GlobalStyle />
      <Switch>
        <StartPage />
        <Route exact path="/attack/:id/:away/:home" component={AttackMode} />
        <Route path="/defense" component={DefenseMode} />
      </Switch>
    </BrowserRouter>
  );
}

export default App;
