import { GlobalAction } from 'util/action.js';

function globalReducer(state, { type, payload }) {
  switch (type) {
    case GlobalAction.SELECT_TEAM: {
      return {
        gameId: payload.gameId,
        playTeam: payload.playTeam,
        home: payload.home
      }
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