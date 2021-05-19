import { initialBallCount } from 'variables/initialData';

const getDeepCopy = (original) => JSON.parse(JSON.stringify(original));

const ballCountReducer = (state, action) => {
  const deepCopied = getDeepCopy(state);
  if (action.attackState) deepCopied.awayCount += 1;
  if (!action.attackState) deepCopied.homeCount += 1;

  switch (action.payload) {
    case 'strike':
      deepCopied.S += 1;
      deepCopied.type = '스트라이크';
      return deepCopied;
    case 'ball':
      deepCopied.B += 1;
      deepCopied.type = '볼';
      return deepCopied;
    case 'out':
      deepCopied.O += 1;
      deepCopied.type = '아웃';
      return deepCopied;
    case 'hit':
      deepCopied.isHit = true;
      deepCopied.type = '안타';
      deepCopied.B = 0;
      deepCopied.S = 0;
      return deepCopied;
    case 'resetRoundBallCount':
      return {
        ...initialBallCount,
        homeCount: state.homeCount,
        awayCount: state.awayCount,
      };
    case 'runToBase':
      return {
        ...initialBallCount,
        O: state.O,
        homeCount: state.homeCount,
        awayCount: state.awayCount,
      };
    case 'threeStrike':
      return {
        ...initialBallCount,
        O: state.O + 1,
        homeCount: state.homeCount,
        awayCount: state.awayCount,
      };
    default:
  }
};

const playerReducer = (state, action) => {
  const deepCopied = getDeepCopy(state);
  switch (action.payload) {
    case 'updatePlayerHistory':
      deepCopied.history = [...deepCopied.history, action.ballCount];
      return deepCopied;
    case 'changeTurn':
      const data = action.data;
      return data;

    default:
  }
};

export { ballCountReducer, playerReducer };
