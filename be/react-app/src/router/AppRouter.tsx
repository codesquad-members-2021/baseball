import React from "react";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import { Home, Login, OAuth, Root } from "../pages";
import { ROUTE_ROOT, ROUTE_HOME, ROUTE_LOGIN, ROUTE_OAUTH } from "./const";

export const AppRouter = () => (
  <BrowserRouter>
      <Switch>
        <Route exact path={ROUTE_ROOT} component={Root} />
        <Route path={ROUTE_HOME} component={Home} />
        <Route path={ROUTE_LOGIN} component={Login} />
        <Route path={ROUTE_OAUTH} component={OAuth} />
      </Switch>
  </BrowserRouter>
);
