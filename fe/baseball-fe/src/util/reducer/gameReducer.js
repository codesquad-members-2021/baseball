import { GameAction } from 'util/action.js';

function gameReducer(state, { type, payload }) {
  switch (type) {
    case GameAction.START: {
      return {
        ...state,
        mode: payload.mode,
        home: payload.home,
        away: payload.away,
        nthBatter: 0,
        ballCount: {
          strike: 0,
          ball: 0,
          out: 0,
        },
        halfInning: {
          currentInning: payload.game_info.current_inning,
          frame: payload.game_info.frame
        },
      }
    }

    case GameAction.STRIKE: {
      const newState = { ...state, ballCount: { ...state.ballCount }};

      if (++newState.ballCount.strike === 3) {
        newState.ballCount.out += 1;
        newState.ballCount.strike = 0;
      }

      newState.latestAction = {
        result: "strike",
        time: new Date().value()
      };
      return newState;
    }

    case GameAction.BALL: {
      const newState = { ...state, ballCount: { ...state.ballCount }};

      if (++newState.ballCount.ball === 4) {
        if (newState.ballCount.strike < 2) {
          newState.ballCount.strike++;
        }
        newState.ballCount.ball = 0;
      }

      newState.latestAction = {
        result: "ball",
        time: new Date().value()
      };
      return newState;
    }

    case GameAction.OUT: {
      const newState = { ...state, ballCount: { ...state.ballCount }};
      newState.ballCount.out += 1;
      newState.latestAction = {
        result: "out",
        time: new Date().value()
      };
      return newState;
    }
  }
}

export default gameReducer;

function organizeResult(state) {
  
}
