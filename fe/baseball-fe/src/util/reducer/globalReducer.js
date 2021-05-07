import { GlobalAction } from 'util/action.js';

function globalReducer(state, { type, payload }) {
  switch (type) {
    case GlobalAction.SELECT_TEAM: {
      return { ...state, ...payload }
    }
  }
};

export default globalReducer;
