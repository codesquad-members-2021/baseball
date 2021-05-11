import { useState } from 'react';

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

  const getNewScore = (team) => {
    if (!base[3]) return score;
    const newScore = { ...score };
    newScore[team][newScore[team].length - 1]++;
    return newScore;
  };
  const getNewBase = (index) => {
    const newBase = { ...base };
    const baseStatus = Object.values(base);
    const newBaseStatus =
      index === 0 ? [true, ...baseStatus.slice(0, -1)] : [false, ...baseStatus.slice(0, -1)];
    newBaseStatus.forEach((status, idx) => (newBase[idx + 1] = status));
    return newBase;
  };
  const safetyDispatch = ({ type, turn, power }) => {
    console.log(score, base);
    const team = turn ? 'home' : 'away';
    if (type === 'clear') {
      const newScore = { ...score };
      newScore[team].push(0);
      setScore(newScore);
      setBase({ 1: false, 2: false, 3: false });
      return;
    }
    for (let i = 0; i < power; i++) {
      //트렌지션 함수 자리
      const newScore = getNewScore(team);
      const newBase = getNewBase(i);
      setBase(newBase);
      setScore(newScore);
    }
  };

  return { score, base, safetyDispatch };
};

export default useScoreNBase;
