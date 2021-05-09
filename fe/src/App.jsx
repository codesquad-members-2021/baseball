import React, { useState } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import "./App.css";
import "./reset.css";
import Main from "./components/main/Main";
import Game from "./components/game/Game";

export const GlobalContext = React.createContext();

function App() {
  const [myTeam, setMyTeam] = useState(null);
  const [counterTeam, setCounterTeam] = useState(null);
  const [homeTeam, setHomeTeam] = useState(null);
  const [currGameState, setCurrGameState] = useState(null);
  const [currPlayer, setCurrPlayer] = useState(null);

  const baseballState = {
    teamInfo: {
      myTeam,
      setMyTeam,
      counterTeam,
      setCounterTeam,
      homeTeam,
      setHomeTeam,
      currGameState,
      setCurrGameState,
      currPlayer,
      setCurrPlayer,
    },
  };
  return (
    <GlobalContext.Provider value={baseballState.teamInfo}>
      <Router>
        <Switch>
          <Route exact path="/">
            <Main />
          </Route>
          <Route path="/game">
            <Game />
          </Route>
        </Switch>
      </Router>
    </GlobalContext.Provider>
  );
}

export default App;
