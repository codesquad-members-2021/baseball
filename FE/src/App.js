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
    display: flex;
    justify-content: center;
    align-items: center;
    background-image: linear-gradient( rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3) ), url("https://content.api.news/v3/images/bin/85e6759097486d20c75d0f195b0e0913");
    background-repeat: no-repeat;
    background-position: center center;
    min-width: 1280px;
    width: 1280px;
    height: 720px;
    margin: 5rem;
  }

`;
