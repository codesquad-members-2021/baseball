import { useState } from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  Redirect,
} from "react-router-dom";
import Home from "../Home/Home";

const NoMatch = () => {
  const [isLoadHome, setIsLoadHome] = useState(false);
  const loadHome = () => {
    setIsLoadHome(true);
  };
  return (
    <Router>
      {isLoadHome ? (
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
        </Switch>
      ) : (
        <>
          <div>잘못된 접근입니다. </div>
          <button onClick={loadHome}>
            <Link to="/">메인으로</Link>
          </button>
        </>
      )}
    </Router>
  );
};

export default NoMatch;
