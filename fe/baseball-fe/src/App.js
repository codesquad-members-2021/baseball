import './App.css';
import React, { useReducer } from 'react';
import { GlobalContext } from './util/context.js';
import globalReducer from './util/reducer/globalReducer.js';

import MainPage from './pages/MainPage/MainPage.js';
import GamePage from './pages/GamePage/GamePage.js';

const initialState = {
  gameId: null,
  playTeam: null,
  home: null
}

function App() {
  const [state, dispatch] = useReducer(globalReducer, initialState);

  return (
    <div className="App">
      <GlobalContext.Provider value={{ dispatch }}>
        {state.gameId ? <GamePage/> : <MainPage/>}
      </GlobalContext.Provider>
    </div>
  );
}

export default App;
