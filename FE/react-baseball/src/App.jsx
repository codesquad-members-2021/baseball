import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { createGlobalStyle, ThemeProvider } from 'styled-components';
import './App.css';
import PlayScreen from './routes/PlayScreen';
import StartScreen from './routes/StartScreen';
import theme from './theme';

function App() {
  const GlobalStyle = createGlobalStyle`
  * {
    padding:0; 
    margin:0;
  }

  body{
    box-sizing:border-box;
  }
  
  ol, ul {
    list-style: none;
  }
`;

  return (
    <ThemeProvider theme={theme}>
      <GlobalStyle />
      <BrowserRouter>
        <Switch>
          <Route path='/' exact>
            <StartScreen />
          </Route>
          <Route path='/play-screen'>
            <PlayScreen />
          </Route>
        </Switch>
      </BrowserRouter>
    </ThemeProvider>
  );
}

export default App;
