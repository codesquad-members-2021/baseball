import './App.css';
import { useReducer } from 'react';
import { GlobalContext } from './util/context.js';
import globalReducer from './util/reducer/globalReducer.js';

import LoginPage from './pages/LoginPage/LoginPage.js';
import LoadingPage from './pages/LoadingPage/LoadingPage.js';
import MainPage from './pages/MainPage/MainPage.js';
import GamePage from './pages/GamePage/GamePage.js';

const _initialState = {
  userId: null,
  // isLoading: false,
  gameId: null,
  playTeam: null,
  home: null,
  initialGameState: null,
}

function App() {
  const [globalState, globalDispatch] = useReducer(globalReducer, _initialState);

  const nextPage = () => {
    if (globalState.userId === null) return <LoginPage/>;
    if (globalState.gameId === null) return <MainPage/>;
    if (globalState.initialGameState === null) return <LoadingPage/>;
    return <GamePage/>;
  }

  return (
    <div className="App">
      <GlobalContext.Provider value={{ globalState, globalDispatch }}>
        {nextPage()}
      </GlobalContext.Provider>
    </div>
  );
}

export default App;
