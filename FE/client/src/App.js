import { createGlobalStyle } from "styled-components";
import Home from "Components/Home";

export const GlobalStyle = createGlobalStyle`
  *{
    padding:0; 
    margin:0;
  }
  body{
    font-family: 'Noto Sans KR';
    box-sizing:border-box;
  }
  
  ol, ul {
    list-style: none;
  }
`;

function App() {
  return (
    <div>
      <GlobalStyle />
      <Home />
    </div>
  );
}

export default App;
