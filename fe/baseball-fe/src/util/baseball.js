const Baseball = {
  pitch: () => {
    const rand =  Math.floor(Math.random() * 3);
    
    // if (rand === 0) return 'strike';
    // if (rand === 1) return 'ball';
    // if (rand === 2) return 'out';

    return 'hit';
  },
  generateHitBase: () => {
    const rand = Math.random();
    return 1;

    console.log('hit random:', rand);
    if (rand >= 0.97) return 3;
    if (rand >= 0.90) return 2;
    return 1;
  }
}

export default Baseball;