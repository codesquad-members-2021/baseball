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

function App() {
  return (
    <div>
      <GlobalStyle />
      <Page />
    </div>
  );
}

export default App;
