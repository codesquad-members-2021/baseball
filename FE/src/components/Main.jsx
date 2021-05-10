import React, { useState } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import styled from "styled-components";
import Home from "./Home/Home";
import Intro from "./Intro/Intro";
import InGame from "./InGame/InGame";
import NoMatch from "./NoMatch/NoMatch";

const Main = () => {
	const [gameId, setGameId] = useState(1);
	// gameId가 undefined일 땐 fetch가 난리가 난다
	// gameId가 정해지지 않는, 그러니까 바로 InGame으로 들어갈 수 없게 철저히 막거나
	// 임의의 gameId(0따위)를 넣고 프레디에게 0번게임은 가짜게임, 가짜데이터로 채워달라고 하거나
	return (
		<Router>
			<MainContext.Provider value={{ gameId, setGameId }}>
				<StyledMain>
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
				</StyledMain>
			</MainContext.Provider>
		</Router>
	);
};

const StyledMain = styled.div`
	background-image: url("image/mlbground_edit.jpg");
	background-repeat: no-repeat;
	min-width: 1280px;
	min-height: 720px;
`;
export const MainContext = React.createContext();

export default Main;
