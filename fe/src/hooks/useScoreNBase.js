import { useEffect, useState } from 'react';

/*
한루 한루 주자가 뛰는 것을 애니메이션 넣어주기 위해서 한번에 계산하기 보다는
for문으로 한번씩 나눠서 실행 
*/

const useScoreNBase = ({
  score: initialScore = { home: [0], away: [] },
  base: initialBase = { 1: false, 2: false, 3: false },
}) => {
  const [score, setScore] = useState(initialScore);
  const [base, setBase] = useState(initialBase);

  const getNewScore = (score, team) => {
    if (!base[3]) return score;
    const newScore = { ...score };
    newScore[team][newScore[team].length - 1] += 1;
    return newScore;
  };
  const getNewBase = (base, runFirstBase) => {
    const newBase = { ...base };
    const baseStatus = Object.values(newBase);
    const newBaseStatus = runFirstBase
      ? [true, ...baseStatus.slice(0, -1)]
      : [false, ...baseStatus.slice(0, -1)];
    newBaseStatus.forEach((status, idx) => (newBase[idx + 1] = status));
    return newBase;
  };
  const safetyDispatch = ({ type, turn, runFirstBase }) => {
    const team = turn ? 'home' : 'away';
    switch (type) {
      case 'clear':
        const newScore = { ...score };
        newScore[team].push(0);
        setScore(newScore);
        setBase({ 1: false, 2: false, 3: false });
        return;
      case 'onBase':
        setBase(getNewBase(base, runFirstBase));
        setScore(getNewScore(score, team));
        return;
      default:
        throw Error('잘못된 safetyDispatch 타입입니다.');
    }
  };

  return { score, base, safetyDispatch };
};

export default useScoreNBase;
