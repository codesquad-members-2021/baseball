import { RecordAction } from 'util/action.js';

function recordReducer(state, { type, payload }) {
  switch (state) {
    case RecordAction.HIT: {
      return [payload, ...state];
    }

    case RecordAction.STRIKE: {
    }

    case RecordAction.BALL: {
      
    }

    case RecordAction.OUT: {

    }
  }
}

export default recordReducer;