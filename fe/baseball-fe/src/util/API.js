const BASE = 'http://3.34.140.110:8080';
// const BASE = 'http://localhost:3030';

const API = {
  games: () => BASE + '/games',
  selectTeam: ({ gameId, teamId, userId }) => BASE + `/games/${gameId}/teams/${teamId}/user/${userId}`,
  cancelTeam: ({ gameId, teamId, userId }) => BASE + `/games/${gameId}/teams/${teamId}/user/${userId}`,
  start: ({ gameId, userId }) => BASE + `/games/${gameId}/start/user/${userId}`,
  pitch: ({ gameId, userId }) => BASE + `/games/${gameId}/pitch/user/${userId}`,
  halfInning: ({ gameId, userId }) => BASE + `/games/${gameId}/halfInning/user/${userId}`
  // login: ({ userId }) => BASE + `/users/${userId}`,
  // teamSelect: ({ gameId, teamId }) => BASE + `/games/${gameId}/teams/${teamId}`,
  // games: () => BASE + '/games',
  // start: ({ id }) => BASE + `/games/${id}/start`,
  // score: ({ id }) => BASE + `/games/${id}/score`,
  // pitch: ({ id }) => BASE + `/games/${id}/pitch`,
  // halfInning: ({ id }) => BASE + `/games/${id}/halfInning`
}

export default API;