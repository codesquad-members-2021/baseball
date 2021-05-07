// const BASE = 'http://04e1da81-9181-4cf8-8346-4d3fbe5479ff.mock.pstmn.io';
const BASE = 'http://localhost:3030'

const API = {
  matches: () => BASE + '/matches',
  start: ({ id }) => BASE + `/games/${id}/start`,
}

export default API;