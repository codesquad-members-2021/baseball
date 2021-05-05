import { BrowserRouter, Route, Switch } from "react-router-dom";
import Home from "pages/Home";
import Game from "pages/Game";

const App = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route path="/" exact>
          <Home />
        </Route>
        <Route path="/game:team">
          <Game />
        </Route>
      </Switch>
    </BrowserRouter>
  );
}

export default App;
