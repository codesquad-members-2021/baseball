import { createContext } from 'react';

const boardHistory = {
  S: 0,
  B: 0,
  O: 0,
};

const BoardHistoryContext = createContext();

export { boardHistory, BoardHistoryContext };
