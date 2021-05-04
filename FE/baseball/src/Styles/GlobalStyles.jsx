import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyles = createGlobalStyle`

  ${reset};

  * {
    box-sizing: border-box;
  }

 body {
   
   font-family: 'Orbitron', sans-serif;
 }

 a {
   text-decoration: none;
   color: #fff;
 }

 .App {
  display: flex;
  justify-content: center;
  align-items: center;
 }
`;

export default GlobalStyles;
