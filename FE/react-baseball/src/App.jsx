import { useReducer, useState, createContext } from 'react';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import styled, { createGlobalStyle, ThemeProvider } from 'styled-components';
import ballReducer from './components/reducer/ballReducer';
import {
  boardHistory,
  BoardHistoryContext,
} from './components/provider/Context';
import './App.css';
import PlayScreen from './routes/PlayScreen';
import StartScreen from './routes/StartScreen';
import theme from './theme';
import useToggle from './components/hooks/useToggle';

function App() {
  const [ballCnt, dispatch] = useReducer(ballReducer, boardHistory);
  const [playable, setPlayable] = useState(true);
  const [myTeam, setMyTeam] = useState([]);
  const [myTeamName, setMyTeamName] = useState('');
  const [counterTeam, setCounterTeam] = useState([]);
  const [counterTeamName, setCounterTeamName] = useState('');
  const [homeTeam, setHomeTeam] = useState(null);
  const [awayTeam, setAwayTeam] = useState(null);
  const [currInning, setCurrInning] = useState(1);
  const [currPitcher, setCurrPitcher] = useState(null);
  const [currHitter, setCurrHitter] = useState(null);
  const [currTeamLog, setCurrTeamLog] = useState([]);
  const [isHome, setIsHome] = useState(false);
  const [totalOutCount, setTotalOutCount] = useState(0);
  const [isDefense, setIsDefense] = useState(false);
  const [inningTop, toggleinningTop] = useToggle(true);

  const baseballState = {
    teamInfo: {
      myTeam,
      setMyTeam,
      myTeamName,
      setMyTeamName,
      counterTeam,
      setCounterTeam,
      counterTeamName,
      setCounterTeamName,
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
      isHome,
      setIsHome,
      totalOutCount,
      setTotalOutCount,
      isDefense,
      setIsDefense,
      inningTop,
      toggleinningTop,
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
