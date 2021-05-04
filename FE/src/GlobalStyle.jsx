import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`
  ${reset};

  body {
    background-image: url("image/mlbground_edit.jpg");
    background-repeat: no-repeat;
    background-position: 20rem 5rem;
    min-width: 1280px;
    min-height: 720px;
    padding: 0;
    margin: 0;
    font-family: 'Noto Sans KR', sans-serif;
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
