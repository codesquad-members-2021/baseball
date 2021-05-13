import { GameAction, RecordAction } from 'util/action.js';
import { RunnerMode, RunnerModeSequence, BatterMode } from 'util/mode.js';
import Baseball from 'util/baseball.js';

function _nextRunnerMode({ currMode }) {
  return RunnerModeSequence[RunnerModeSequence.findIndex(v => v === currMode) + 1];
}

// function _dstRunnerMode({ currMode, hitBase }) {
//   return RunnerModeSequence[RunnerModeSequence.findIndex(v => v === currMode) + hitBase * 2];
// }

function gameReducer(state, { type, payload }) {
  switch (type) {
    case GameAction.STRIKE: {
      const newState = { ...state, ball_count: { ...state.ball_count, strike: state.ball_count.strike + 1 }};

      if (newState.ball_count.strike === 3) {
        newState.additionalRecord = Baseball.generateRecord({ action: RecordAction.OUT, gameState: newState });
        newState.ball_count.strike = 0;
        return gameReducer(newState, { type: GameAction.OUT });
      }

      return newState;
    }

    case GameAction.BALL: {
      const newState = { ...state, ball_count: { ...state.ball_count, ball: state.ball_count.ball + 1 }};

      if (newState.ball_count.ball === 4) {
        newState.ball_count.strike = Math.min(2, newState.ball_count.strike + 1);
        newState.additionalRecord = Baseball.generateRecord({ action: RecordAction.BALL4, gameState: newState });
        newState.ball_count.ball = 0;
        return gameReducer({ ...newState }, { type: GameAction.RUN_START });
      }

      return newState;
    }

    case GameAction.OUT: {
      const newState = { ...state, ball_count: { ...state.ball_count, out: state.ball_count.out + 1 }};

      if (newState.ball_count.out === 3) {
        return gameReducer({ ...newState }, { type: GameAction.HALF_INNING_END });
      }

      return gameReducer({ ...newState }, { type: GameAction.NEXT_BATTER });
    }

    case GameAction.HIT: {
      return {
        ...state,
        batter: { ...state.batter, mode: BatterMode.HIT }
      }
    }

    case GameAction.RUN_START: {
      console.log('run-start');
      const newRunners = [...state.runners].map(runner => ({
        ...runner,
        mode: _nextRunnerMode({ currMode: runner.mode })
      }));

      if (state.batter) {
        newRunners.push({
          playerId: state.batter.id,
          mode: RunnerMode.RUN_TO_FIRST,
        });
      }

      return {
        ...state,
        runners: newRunners
      };
    }

    case GameAction.RUN_END: {
      const newRunners = [...state.runners];

      newRunners[payload.runnerIdx] = {
        ...newRunners[payload.runnerIdx],
        mode: _nextRunnerMode({ currMode: newRunners[payload.runnerIdx].mode })
      };

      return {
        ...state,
        runners: newRunners
      }
    }

    case GameAction.NEXT_BATTER: {
      console.log('next-batter');
      return {
        ...state,
        batter: state.home.mode === 'FIELDING' ?
          state.home.batters[state.nth_batter % state.home.batters.length] :
          state.away.batters[state.nth_batter % state.away.batters.length],
        nth_batter: state.nth_batter + 1,
        needToPost: true,
      }
    }

    case GameAction.SCORE: {
      const newRunners = [...state.runners].filter(runner => runner.mode !== RunnerMode.SCORE);

      return payload.isHomeFielding ?
      { ...state, away: { ...state.away, score: state.away.score + 1 }, runners: newRunners, needToPost: true } :
      { ...state, home: { ...state.home, score: state.home.score + 1 }, runners: newRunners, needToPost: true };
    }

    case GameAction.HALF_INNING_END: {

    }

    case GameAction.ADDITIONAL_RECORD_END: {
      return { ...state, additionalRecord: null };
    }

    case GameAction.NEED_TO_POST_END: {
      return { ...state, needToPost: false };
    }
  }
}

export default gameReducer;

function organizeResult(state) {
  
}
