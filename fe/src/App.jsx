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
  const [expeditionTeam, setExpeditionTeam] = useState(null);
  const [currInning, setCurrInning] = useState(null);
  const [currPitcher, setCurrPitcher] = useState(null);
  const [currHitter, setCurrHitter] = useState(null);
  const [currTeamLog, setCurrTeamLog] = useState([]);
  const [currS, setCurrS] = useState(0);
  const [currH, setCurrH] = useState(0);
  const [currB, setCurrB] = useState(0);
  const [currO, setCurrO] = useState(0);

  const baseballState = {
    teamInfo: {
      myTeam,
      setMyTeam,
      counterTeam,
      setCounterTeam,
      homeTeam,
      setHomeTeam,
      expeditionTeam,
      setExpeditionTeam,
      currPitcher,
      setCurrPitcher,
      currHitter,
      setCurrHitter,
      currInning,
      setCurrInning,
      currTeamLog,
      setCurrTeamLog,
      currS,
      setCurrS,
      currH,
      setCurrH,
      currB,
      setCurrB,
      currO,
      setCurrO,
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
