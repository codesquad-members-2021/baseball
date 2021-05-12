// import { RunnerAction } from 'util/action.js';
// import { RunnerMode, RunnerModeSequence } from 'util/mode.js';

// // const RUNNER_MODE = [
// //   // RunnerMode.BAT,
// //   RunnerMode.RUN_TO_FIRST,
// //   RunnerMode.STAY_TO_FIRST,
// //   RunnerMode.RUN_TO_SECOND,
// //   RunnerMode.STAY_TO_SECOND,
// //   RunnerMode.RUN_TO_THIRD,
// //   RunnerMode.STAY_TO_THIRD,
// //   RunnerMode.RUN_TO_HOME,
// //   RunnerMode.SCORE
// // ];

// function _nextRunnerMode({ currMode, isKeepRun = false, hitBase = 1 }) {
//   const nextIdx = RunnerModeSequence.findIndex(v => v === currMode) + 1 + (isKeepRun ? 1 : (hitBase - 1) * 2);
//   return RunnerModeSequence[nextIdx];
// }

// function runnerReducer(state, { type, payload }) {
//   console.log(state, type, payload);
//   switch (type) {
//     // case RunnerAction.RUN: {
//     //   return {
//     //     ...state,
//     //     mode: _nextRunnerMode({ currMode: state.mode }),
//     //     dstMode: _nextRunnerMode({ currMode: state.mode, runCnt: payload?.runCnt})
//     //     // TODO: modeSvg
//     //     // runTo: _baseToRun({ currBase: state.base, cnt: payload?.runCnt})
//     //   };
//     // }

//     case RunnerAction.KEEP_RUN: {
//       return {
//         ...state,
//         mode: _nextRunnerMode({ currMode: state.mode, isKeepRun: true })
//       }
//     }

//     case RunnerAction.STAY: {
//       return {
//         ...state,
//         mode: _nextRunnerMode({ currMode: state.mode }),
//       };
//     }
    
//     case RunnerAction.BAT: {
      
//     }

//     case RunnerAction.HIT: {

//     }
//   }
// }

// export default runnerReducer;
