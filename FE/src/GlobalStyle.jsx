import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const GlobalStyle = createGlobalStyle`
  ${reset};

  body {
    padding: 0;
    margin: 0;
    font-family: 'Noto Sans KR', sans-serif;
    display:flex;
    justify-content:center;
  }

  * {
    box-sizing: border-box;
  }

  a{
    text-decoration:none;
    color:inherit;
     }

  ul {
    list-style: none;
    }

  button{
    display: flex;
    cursor: pointer;
    outline: none;
    border-radius: 3px;
    };
    
    input{
        display: flex;
        outline: none;
        padding-left: 10px;
    }

`;

export default GlobalStyle;
