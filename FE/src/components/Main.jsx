import React, { useState } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import styled from "styled-components";
import Home from "./Home/Home";
import Intro from "./Intro/Intro";
import InGame from "./InGame/InGame";
import NoMatch from "./NoMatch/NoMatch";

const Main = () => {
	const [gameId, setGameId] = useState();
	const [teamId, setTeamId] = useState();
	const [loginStatus, setLoginStatus] = useState(false);
	const [userId, setUserId] = useState();
	return (
		<MainContext.Provider value={{ gameId, setGameId, teamId, setTeamId, loginStatus, setLoginStatus, userId, setUserId }}>
			<StyledMain>
				<RouterComponent />
			</StyledMain>
		</MainContext.Provider>
	);
};

const RouterComponent = () => (
	<Router>
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
);

const StyledMain = styled.div`
	background-image: url("image/mlbground_edit.jpg");
	background-repeat: no-repeat;
	min-width: 1280px;
	min-height: 720px;
`;
export const MainContext = React.createContext();

export default Main;
