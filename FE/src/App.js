import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import GlobalStyle from './GlobalStyle';
import Home from './components/Home/Home';
import Intro from './components/Intro/Intro';
import InGame from './components/InGame/InGame';
import NoMatch from './components/NoMatch/NoMatch';

function App() {
  return (
    <>
      <Router>
        <GlobalStyle />
        <Switch>
          <Route path="/intro">
            <Intro />
          </Route>
          <Route path="/ingame">
            <InGame />
          </Route>
          <Route exact path="/">
            <Home />
          </Route>
          <Route path="/image"></Route>
          <Route path="*">
            <NoMatch />
          </Route>
        </Switch>
      </Router>
    </>
  );
}

export default App;
