import { createContext, useState } from "react";
import { BrowserRouter, Redirect, Route, Switch } from "react-router-dom";
import { Intro } from "@/Routes/Intro";
import { Home } from "@/Routes/Home";
import Game from "@/Routes/Game";
import { getAPI } from "@/Utils/API";

export const RouterContext = createContext();

const Router = () => {
  const [gameData, setGameData] = useState(null);
  const [selectedTeam, setSelectedTeam] = useState(null);

  const setGame = (action) => {
    if (action) {
      getAPI.game(action.gameID).then((res) => {
        if (res && res.data) {
          setGameData(res.data);
        }
      });
      setSelectedTeam(action.selectedTeam);
    }
  };

  return (
    <RouterContext.Provider value={{ gameData, selectedTeam, setGame }}>
      <BrowserRouter>
        <Switch>
          <Route exact path="/" component={Intro} />
          <Route path="/home" component={Home} />
          <Route path="/game" component={Game} />
          <Redirect from="*" to="/" />
        </Switch>
      </BrowserRouter>
    </RouterContext.Provider>
  );
};

export default Router;
