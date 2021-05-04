import { useContext, useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import { createGlobalStyle } from 'styled-components';
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

const GlobalStyle = createGlobalStyle`
  body {
    background-image: url("image/mlbground_edit.jpg");
    background-repeat: no-repeat;
    background-position: 20rem 5rem;
    min-width: 1280px;
    min-height: 720px;
  }

`;
