import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import "./App.css";
import Main from "./components/main/Main";
import Game from "./components/game/Game";

function App() {
  return (
    <Router>
      <Switch>
        <Route exact path="/" component={Main} />
        <Route exact path="/game" component={Game} />
      </Switch>
    </Router>
  );
}

export default App;
