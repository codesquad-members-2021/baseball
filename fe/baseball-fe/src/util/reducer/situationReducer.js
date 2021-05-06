import { SituationAction } from 'util/action.js';

function situationReducer(state, { type, payload }) {
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

export default situationReducer;