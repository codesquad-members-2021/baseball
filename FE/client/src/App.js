import React from "react";
import {
  Router, Route, Link
} from "./utils/Router.jsx";
// import { BrowserRouter as Router, Route, Link } from 'react-router-dom';

export const GlobalStyle = createGlobalStyle`
  *{
    padding:0; 
    margin:0;
    box-sizing:border-box;
    &::before{
      box-sizing: border-box;
    }
    &::after{
      box-sizing: border-box;
    }
  }

  body{
    font-family: 'Noto Sans KR';
    
  }
  
  ol, ul {
    list-style: none;
  }
`;

return (
  <Router>
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
          <li>
            <Link to="/users">Users</Link>
          </li>
        </ul>
      </nav>

      {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
      <Route path="/">
        <Home />
      </Route>
      <Route path="/about">
        <About />
      </Route>
      <Route path="/users">
        <Users />
      </Route>

    </div>
  </Router>
);
}

function Home() {
  console.log('I am Home')
  return <h2>Home</h2>;
}

function About() {
  console.log('I am About')
  return <h2>About</h2>;
}

function Users() {
  console.log('I am Users')
  return <h2>Users</h2>;
}
