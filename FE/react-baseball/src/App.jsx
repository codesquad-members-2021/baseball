import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { createGlobalStyle, ThemeProvider } from 'styled-components';
import styled from 'styled-components';
import './App.css';
import PlayScreen from './routes/PlayScreen';
import StartScreen from './routes/StartScreen';
import theme from './theme';
import { useState } from 'react';
import { createContext } from 'react';

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
              <Route path='/play-screen'>
                <PlayScreen />
              </Route>
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

export const PlayableContext = createContext();

export default App;
