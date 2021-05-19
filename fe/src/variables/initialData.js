const initialBallCount = {
  homeCount: 0,
  awayCount: 0,
  type: null,
  S: 0,
  B: 0,
  O: 0,
  isHit: false,
};

class CurrentPlayer {
  constructor(name, uniform_number, turn, hits, ballCountStateArr) {
    this.playerName = name;
    this.uniformNumber = uniform_number;
    this.turn = turn;
    this.hits = hits;
    this.history = ballCountStateArr;
    this.previousAction = null;
  }
}

const temp = {
  playerName: '류현진',
  uniformNumber: 2,
  turn: 1,
  hit: 0,
  history: [],
};

export { initialBallCount, CurrentPlayer };
