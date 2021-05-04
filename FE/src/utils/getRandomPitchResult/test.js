import getRandomPitchResult from './getRandomPitchResult.js';

const test = (cnt) => {
  const stat = {};
  for (let i = 0; i < cnt; i++) {
    const result = getRandomPitchResult();
    if (stat[result]) stat[result] += 1;
    else stat[result] = 1;
  }
  console.log(stat);
};

test(10000);
