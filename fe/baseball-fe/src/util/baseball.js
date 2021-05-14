const Baseball = {
  pitch: () => {
    const rand =  Math.floor(Math.random() * 6);
    
    if (rand === 0) return 'STRIKE';
    if (rand === 1) return 'BALL';
    if (rand === 2) return 'OUT';
    return 'HIT';
  },
  generateHitBase: () => {
    const rand = Math.random();
    return 1;

    // console.log('hit random:', rand);
    if (rand >= 0.97) return 3;
    if (rand >= 0.90) return 2;
    return 1;
  },
  generateRecord: ({ action, gameState }) => ({
    player_id: gameState.batter.id,
    action,
    nth_batter: gameState.nth_batter,
    batter_name: gameState.batter.name,
    strike: gameState.ball_count.strike + (action === 'STRIKE' ? 1 : 0),
    ball: gameState.ball_count.ball + (action === 'BALL' ? 1 : 0)
  }),
  organizeResult: (gameState, home) => {
    const batter = gameState.pitch_result === 'OUT' ? gameState.prevBatter : gameState.batter;
    const runners = gameState.runners.filter(v => v.mode !== null);
  
    return {
      home_id: gameState.home.id,
      away_id: gameState.away.id,
      batting_team_id: home === true ? gameState.away.id : gameState.home.id,
      pitch_result: gameState.pitch_result,
      batter: {
        player_id: batter.id,
        player_name: batter.name,
        player_uniform_number: batter.player_uniform_number,
        is_out: batter.is_out
      },
      ball_count: { ...gameState.ball_count },
      runners: [...runners.map(runner => ({ ...runner }))],
      score: {
        home_score: gameState.home.score,
        away_score: gameState.away.score
      }
    }
  }
}

export default Baseball;