import './App.css';
import { useReducer } from 'react';
import { GlobalContext } from './util/context.js';
import globalReducer from './util/reducer/globalReducer.js';

import MainPage from './pages/MainPage/MainPage.js';
import GamePage from './pages/GamePage/GamePage.js';

const _initialState = {
  gameId: null,
  playTeam: null,
  home: null
}

function App() {
  const [globalState, globalDispatch] = useReducer(globalReducer, _initialState);

  return (
    <div className="App">
      <GlobalContext.Provider value={{ globalState, globalDispatch }}>
        {globalState.gameId ? <GamePage/> : <MainPage/>}
      </GlobalContext.Provider>
    </div>
  );
}

export default App;
