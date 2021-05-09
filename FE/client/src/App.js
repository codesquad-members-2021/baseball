import { createGlobalStyle } from "styled-components";
import Page from "Components/Page";

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


export default App;