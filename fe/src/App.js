import { BrowserRouter, Route, Switch } from "react-router-dom";
import Home from "pages/Home";
import Game from "pages/Game";

function App() {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/game">
          <Game />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
