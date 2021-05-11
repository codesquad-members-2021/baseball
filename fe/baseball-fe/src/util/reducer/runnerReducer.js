import { RunnerAction } from 'util/action.js';

function runnerReducer(state, { type, payload }) {
  switch (type) {
    case RunnerAction.RUN: {
      return { ...state };
    }

    case RunnerAction.STAY: {

    }
    
    case RunnerAction.BAT: {
      
    }

    case RunnerAction.HIT: {

    }
  }
}

export default runnerReducer;
