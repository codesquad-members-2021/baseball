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
  const [myTeam, setMyTeam] = useState([]);
  const [counterTeam, setCounterTeam] = useState([]);
  const [homeTeam, setHomeTeam] = useState(null);
  const [awayTeam, setAwayTeam] = useState(null);
  const [currInning, setCurrInning] = useState(null);
  const [currPitcher, setCurrPitcher] = useState(null);
  const [currHitter, setCurrHitter] = useState(null);
  const [currTeamLog, setCurrTeamLog] = useState([]);
  const [currS, setCurrS] = useState(0);
  const [currH, setCurrH] = useState(0);
  const [currB, setCurrB] = useState(0);
  const [currO, setCurrO] = useState(0);
  const [isHome, setIsHome] = useState(false);

  const baseballState = {
    teamInfo: {
      myTeam,
      setMyTeam,
      counterTeam,
      setCounterTeam,
      homeTeam,
      setHomeTeam,
      awayTeam,
      setAwayTeam,
      currPitcher,
      setCurrPitcher,
      currHitter,
      setCurrHitter,
      currInning,
      setCurrInning,
      currTeamLog,
      setCurrTeamLog,
      currS,
      setCurrS,
      currH,
      setCurrH,
      currB,
      setCurrB,
      currO,
      setCurrO,
      isHome,
      setIsHome,
    },
  };

  return (
    <ThemeProvider theme={theme}>
      <GlobalContext.Provider value={baseballState.teamInfo}>
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
      </GlobalContext.Provider>
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
export const GlobalContext = createContext();

export default App;
