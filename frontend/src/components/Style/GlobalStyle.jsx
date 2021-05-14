import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`
// @font-face {
//   font-family: 'DungGeunMo';
//   src: url('https://cdn.jsdelivr.net/gh/projectnoonnu/noonfonts_six@1.2/DungGeunMo.woff?display=swap') format('woff');
//   font-weight: normal;
//   font-style: normal;
// }
button{
  cursor: pointer;
}
body {
  // font-family: DungGeunMo;
  background: linear-gradient(
          rgba(0, 0, 0, 0.7), 
          rgba(0, 0, 0, 0.7)
        ),url('http://localhost:3000/stadium.jpeg') no-repeat;
}
`;
export default GlobalStyle;
