const getRandomPitchResult = () => {
  let result;
  const num = parseInt(Math.random() * 10); // 0~9
  if (num >= 0 && num <= 4) result = 'BALL';
  else if (num >= 5 && num <= 6) result = 'STRIKE';
  else result = 'HIT';

  return result;
};

export default getRandomPitchResult;

// 가중치
// ball 0.5
// strike 0.2
// hit 0.3
