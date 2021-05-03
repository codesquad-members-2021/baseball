import { GlobalAction } from '../action.js';

function globalReducer(state, { type, payload }) {
  switch (type) {
    case GlobalAction.SELECT_TEAM: {
      // set gameId <- payload
      // set playTeam <- payload
      // set home <- payload
    }
  }
};

export default globalReducer;

/*
dispatch({ type: GlobalAction.SELECT_TEAM, payload: {
  gameId: 123
  playTeam: 'a'
  home: true
}});
*/