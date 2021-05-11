const ballReducer = (ballCnt, action) => {
  switch (action.type) {
    case 'hitS':
      return { ...ballCnt, S: ballCnt.S + 1 };

    case 'hitB':
      return { ...ballCnt, B: ballCnt.B + 1 };

    case 'hitO':
      return { ...ballCnt, S: 0, B: 0, O: ballCnt.O + 1 };

    case 'hitH':
      return { ...ballCnt, S: 0, B: 0, H: ballCnt.H + 1 };

    case 'hitInfo':
      return { ...ballCnt, HitInfo: action.payload };

    default:
      return null;
  }
};

export default ballReducer;
