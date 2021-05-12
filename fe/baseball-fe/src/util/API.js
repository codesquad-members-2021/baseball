// const BASE = 'http://04e1da81-9181-4cf8-8346-4d3fbe5479ff.mock.pstmn.io';
const BASE = 'http://localhost:3030'

const API = {
  games: () => BASE + '/games',
  start: ({ id }) => BASE + `/games/${id}/start`,
  score: ({ id }) => BASE + `/games/${id}/score`
}

export default API;