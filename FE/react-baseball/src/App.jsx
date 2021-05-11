import { useReducer, useState, createContext } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import styled, { createGlobalStyle, ThemeProvider } from 'styled-components';
import ballReducer from './components/reducer/ballReducer';
import {
  boardHistory,
  BoardHistoryContext,
} from './components/provider/ContextB';
import './App.css';
import PlayScreen from './routes/PlayScreen';
import StartScreen from './routes/StartScreen';
import theme from './theme';

function App() {
  const [ballCnt, dispatch] = useReducer(ballReducer, boardHistory);
  const [playable, setPlayable] = useState(true);

  return (
    <ThemeProvider theme={theme}>
      <PlayableContext.Provider value={{ playable, setPlayable }}>
        <GlobalStyle />
        <BrowserRouter>
          <Switch>
            <AppDiv>
              <Route path='/' exact>
                <StartScreen />
              </Route>
              <BoardHistoryContext.Provider value={{ ballCnt, dispatch }}>
                <Route path='/play-screen'>
                  <PlayScreen />
                </Route>
              </BoardHistoryContext.Provider>
            </AppDiv>
          </Switch>
        </BrowserRouter>
      </PlayableContext.Provider>
    </ThemeProvider>
  );
}

const AppDiv = styled.div`
  margin: 50px auto;
  max-width: 1440px;
`;
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

export const PlayableContext = createContext();
export default App;
