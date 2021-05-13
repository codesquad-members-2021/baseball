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
          pitcher: null,
          batter: null,
          pitcher: payload.initialGameState.home.pitcher,
          nth_batter: 0,
          batter: { ...payload.initialGameState.away.batters[0], mode: null },
          runners: [],
          ball_count: {
            strike: 0,
            ball: 0,
            out: 0
          },
          additionalRecord: null,
          needToPost: false,
        }
      };
    }
  }
};

export default globalReducer;
