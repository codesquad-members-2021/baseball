import { BrowserRouter, Redirect, Route, Switch } from "react-router-dom";
import { Intro } from "@/Routes/Intro";
import { Home } from "@/Routes/Home";
import { Game } from "@/Routes/Game";

const Router = () => {
  return (
    <BrowserRouter>
      <Switch>
        <Route exact path="/" component={Intro} />
        <Route path="/home" component={Home} />
        <Route path="/game" component={Game} />
        <Redirect from="*" to="/" />
      </Switch>
    </BrowserRouter>
  );
};

export default Router;
