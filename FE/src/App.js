import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import GlobalStyle from "./GlobalStyle";
import styled from "styled-components";
import Home from "./components/Home/Home";
import NoMatch from "./components/NoMatch/NoMatch";

function App() {
  return (
    <>
      <Router>
        <GlobalStyle />
        <Switch>
          <Route exact path="/">
            <Main>
              <Home />
            </Main>
          </Route>
          <Route path="*">
            <NoMatch />
          </Route>
        </Switch>
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
