const initialBallCount = {
  homeCount: 0,
  awayCount: 0,
  type: '스트라이크',
  S: 0,
  B: 0,
  O: 0,
  isHit: false,
};

class CurrentPlayer {
  constructor({ playerName, num, turn, hit, ballCountStateArr }) {
    this.playerName = playerName;
    this.uniform_number = num;
    this.turn = turn;
    this.hit = hit;
    this.history = ballCountStateArr;
  }
}

const temp = {
  playerName: '류현진',
  uniform_number: 2,
  turn: 1,
  hit: 0,
  history: [],
};

export { initialBallCount, CurrentPlayer };
