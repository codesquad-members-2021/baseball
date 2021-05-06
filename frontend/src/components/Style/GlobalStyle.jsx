import { createGlobalStyle } from 'styled-components';
import reset from 'styled-reset';

const GlobalStyle = createGlobalStyle`${reset};
  @import url('https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;500;700&display=swap');
 
body {
  font-family: 'Noto Sans KR', sans-serif;
  background: linear-gradient(
          rgba(0, 0, 0, 0.7), 
          rgba(0, 0, 0, 0.7)
        ),url('http://localhost:3000/stadium.jpeg') no-repeat;
/* color: white; //text 식별용, 이후 삭제 필요 */
}
`;
export default GlobalStyle;
