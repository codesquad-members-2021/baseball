const ballReducer = (ballCnt, action) => {
  switch (action.type) {
    case 'S':
      return { ...ballCnt, S: ballCnt.S + 1 };
    case 'B':
      return { ...ballCnt, B: ballCnt.B + 1 };
    case 'O':
      return { ...ballCnt, O: ballCnt.O + 1 };
  }
};

export default ballReducer;
