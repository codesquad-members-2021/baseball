import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`${reset};
@font-face {
  font-family: DungGeunMo;
  src: local("DungGeunMo"),
  local("DungGeunMo"),
  url('/font/DungGeunMo.woff')format('woff');
  font-weight: bold;
}
button{
  cursor: pointer;
}
body {
  font-family: DungGeunMo;
  background: linear-gradient(
          rgba(0, 0, 0, 0.7), 
          rgba(0, 0, 0, 0.7)
        ),url('http://localhost:3000/stadium.jpeg') no-repeat;
}
`;
export default GlobalStyle;
