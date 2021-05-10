import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { createGlobalStyle, ThemeProvider } from 'styled-components';
import styled from 'styled-components';
import {
  boardHistory,
  BoardHistoryContext,
} from './components/provider/ContextB';
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
    background-color:black;
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
          <AppDiv>
            <Route path='/' exact>
              <StartScreen />
            </Route>
            <BoardHistoryContext.Provider value={boardHistory}>
              <Route path='/play-screen'>
                <PlayScreen />
              </Route>
            </BoardHistoryContext.Provider>
          </AppDiv>
        </Switch>
      </BrowserRouter>
    </ThemeProvider>
  );
}

const AppDiv = styled.div`
  margin: 50px auto;
  max-width: 1440px;
`;

export default App;
