import { GameAction } from 'util/action.js';
import { RunnerMode, RunnerModeSequence, BatterMode } from 'util/mode.js';

function _nextRunnerMode({ currMode }) {
  return RunnerModeSequence[RunnerModeSequence.findIndex(v => v === currMode) + 1];
}

function _dstRunnerMode({ currMode, hitBase }) {
  return RunnerModeSequence[RunnerModeSequence.findIndex(v => v === currMode) + hitBase * 2];
}

function gameReducer(state, { type, payload }) {
  switch (type) {
    case GameAction.START: {
      return {
        ...state,
        mode: payload.mode,
        home: payload.home,
        away: payload.away,
        pitcher: payload.home.pitcher,
        nthBatter: 1,
        batter: { ...payload.away.batters[0], mode: null },
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
        batter: null,
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
        batter: state.home.mode === 'fielding' ? state.home.batters[state.nthBatter] : state.away.batters[state.nthBatter],
        nthBatter: state.nthBatter + 1, // TODO: cycular
      }
    }

    case GameAction.SCORE: {
      const newRunners = [...state.runners].filter(runner => runner.mode !== RunnerMode.SCORE);

      return payload.isHomeFielding ?
      { ...state, away: { ...state.away, score: state.away.score + 1 }, runners: newRunners } :
      { ...state, home: { ...state.home, score: state.home.score + 1 }, runners: newRunners };
    }
  }
}

export default gameReducer;

function organizeResult(state) {
  
}
