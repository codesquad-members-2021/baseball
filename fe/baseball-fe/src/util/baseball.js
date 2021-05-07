const Baseball = {
  pitch: () => {
    const rand =  Math.floor(Math.random() * 3);
    
    // if (rand === 0) return 'strike';
    // if (rand === 1) return 'ball';
    // if (rand === 2) return 'out';

    return 'ball';
  }
}

export default Baseball;