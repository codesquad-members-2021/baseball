import "./App.css";
import { createGlobalStyle } from "styled-components";

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
    <div className="App">
      <GlobalStyle />
    </div>
  );
}

export default App;
