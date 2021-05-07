import { GameAction } from 'util/action.js';

function gameReducer(state, { type, payload }) {
  switch (type) {
    case GameAction.START: {
      return {
        ...state,
        mode: payload.mode,
        home: payload.home,
        away: payload.away,
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
    // case GameAction.PITCH: {
    //   return {

    //   }
    // }

    case GameAction.STRIKE: {
      const newState = { ...state, ballCount: { ...state.ballCount }};
      // newState.ballCount.strike += 1;
      if (++newState.ballCount.strike === 3) {
        newState.ballCount.out += 1;
        newState.ballCount.strike = 0;
      }
      console.log('strike');
      newState.latestResult = "strike";
      return newState;
    }

    case GameAction.BALL: {
      const newState = { ...state, ballCount: { ...state.ballCount }};
      // newState.ballCount.ball += 1;
      if (++newState.ballCount.ball === 4) {
        if (newState.ballCount.strike < 2) {
          newState.ballCount.strike++;
        }
        newState.ballCount.ball = 0;
      }
      console.log('ball');
      newState.latestResult = "ball";
      return newState;
    }

    case GameAction.OUT: {
      const newState = { ...state, ballCount: { ...state.ballCount }};
      newState.ballCount.out += 1;
      console.log('out');
      newState.latestResult = "out";
      return newState;
    }
  }
}

export default gameReducer;

function organizeResult(state) {
  
}
