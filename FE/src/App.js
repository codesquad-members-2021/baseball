import './style/reset.css';
import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
  body {
      width: 1440px;
      margin: 0 auto;
  }
`;

const App = () => {
    return (
        <>
            <GlobalStyle />
            <div>123</div>
        </>
    );
};
export default App;
