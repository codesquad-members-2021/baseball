//context
import {
  useState,
  useEffect,
  createContext,
  useContext,
  useReducer,
} from 'react';

const GameStateContext = createContext();
const DispatchContext = createContext();
const GameLogContext = createContext();
const LogDispatchContext = createContext();

//useReducer에 useEffect적용해보기
const gameReducer = (state, action) => {
  switch (action.type) {
    case 'init':
      return action.data;
    case 'pitch':
      return action.payload;
  }
};

const historyReducer = (logState, action) => {
  switch (action.type) {
    case 'log':
      return [...logState, action.payload];
  }
};

function GameProvider({ children, gameData }) {
  const [state, dispatch] = useReducer(gameReducer, gameData);
  const [logState, logDispatch] = useReducer(historyReducer, []);

  useEffect(() => {
    dispatch({ type: 'init', data: gameData });
  }, [gameData]);

  return (
    <GameStateContext.Provider value={{ state }}>
      <DispatchContext.Provider value={dispatch}>
        <GameLogContext.Provider value={{ logState }}>
          <LogDispatchContext.Provider value={logDispatch}>
            {children}
          </LogDispatchContext.Provider>
        </GameLogContext.Provider>
      </DispatchContext.Provider>
    </GameStateContext.Provider>
  );
}
function useLogState() {
  const context = useContext(GameLogContext);
  if (!context) {
    throw new Error('Cannot find GameProvider');
  }
  return context;
}
function useLogDispatch() {
  const context = useContext(LogDispatchContext);
  if (!context) {
    throw new Error('Cannot find GameProvider');
  }
  return context;
}
function useGameState() {
  const context = useContext(GameStateContext);
  if (!context) {
    throw new Error('Cannot find GameProvider');
  }
  return context;
}
function useDispatch() {
  const context = useContext(DispatchContext);
  if (!context) {
    throw new Error('Cannot find GameProvider');
  }
  return context;
}

export {
  GameStateContext,
  GameProvider,
  useGameState,
  useDispatch,
  useLogState,
  useLogDispatch,
};
