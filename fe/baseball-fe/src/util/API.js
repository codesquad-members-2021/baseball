<<<<<<< HEAD
// const BASE = 'http://04e1da81-9181-4cf8-8346-4d3fbe5479ff.mock.pstmn.io';
const BASE = 'http://localhost:3030'
// const BASE = 'http://52.78.193.180:8080';
=======
const BASE = 'http://3.36.67.218:8080';
// const BASE = 'http://localhost:3030';
>>>>>>> feat: 간단한 로그인 페이지 구현

const API = {
  login: ({ userId }) => BASE + `/users/${userId}`,
  games: () => BASE + '/games',
  start: ({ id }) => BASE + `/games/${id}/start`,
  score: ({ id }) => BASE + `/games/${id}/score`,
  pitch: ({ id }) => BASE + `/games/${id}/pitch`,
  halfInning: ({ id }) => BASE + `/games/${id}/halfInning`
}

export default API;