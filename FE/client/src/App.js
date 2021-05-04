import { createGlobalStyle } from "styled-components";
import Page from "Components/Page";

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
      <Page />
    </div>
  );
}

export default App;
