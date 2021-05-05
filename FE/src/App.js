import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import GlobalStyle from "./GlobalStyle";
import styled from "styled-components";
import Home from "./components/Home/Home";
import Intro from "./components/Intro/Intro";
import InGame from "./components/InGame/InGame";
import NoMatch from "./components/NoMatch/NoMatch";

function App() {
	return (
		<>
			<Router>
				<GlobalStyle />
				<Main>
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
				</Main>
			</Router>
		</>
	);
}

const Main = styled.div`
	background-image: url("image/mlbground_edit.jpg");
	background-repeat: no-repeat;
	min-width: 1280px;
	min-height: 720px;
`;

export default App;
