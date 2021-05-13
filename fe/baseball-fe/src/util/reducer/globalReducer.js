import { GlobalAction } from 'util/action.js';

function globalReducer(state, { type, payload }) {
  switch (type) {
    case GlobalAction.SELECT_TEAM: {
      return { ...state, ...payload };
    }
    
    case GlobalAction.LOGIN: {
      return { ...state, ...payload };
    }

    case GlobalAction.GAME_START: {
      return {
        ...state,
        initialGameState: {
          ...payload.initialGameState,
          runners: [],
          ball_count: {
            strike: 0,
            ball: 0,
            out: 0
          },
        }
      };
    }
  }
};

export default globalReducer;
