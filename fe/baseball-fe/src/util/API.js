const BASE = 'http://3.34.140.110:8080';
// const BASE = 'http://localhost:3030';

const API = {
  games: () => BASE + '/games',
  selectTeam: ({ gameId, teamId, userId }) => BASE + `/games/${gameId}/teams/${teamId}/user/${userId}`,
  cancelTeam: ({ gameId, teamId, userId }) => BASE + `/games/${gameId}/teams/${teamId}/user/${userId}`,
  start: ({ gameId, userId }) => BASE + `/games/${gameId}/start/user/${userId}`,
  pitch: ({ gameId, userId }) => BASE + `/games/${gameId}/pitch/user/${userId}`,
  pitchResult: ({ gameId, userId }) => BASE + `/games/${gameId}/pitchResult/user/${userId}`,
  batterRecord: ({ gameId, userId}) => BASE + `/games/${gameId}/batterRecord/user/${userId}`,
  halfInning: ({ gameId, userId }) => BASE + `/games/${gameId}/halfInning/user/${userId}`,
  // login: ({ userId }) => BASE + `/users/${userId}`,
  // teamSelect: ({ gameId, teamId }) => BASE + `/games/${gameId}/teams/${teamId}`,
  // games: () => BASE + '/games',
  // start: ({ id }) => BASE + `/games/${id}/start`,
  score: ({ gameId, userId }) => BASE + `/games/${gameId}/score/user/${userId}`,
  // pitch: ({ id }) => BASE + `/games/${id}/pitch`,
  // halfInning: ({ id }) => BASE + `/games/${id}/halfInning`
}

// http://localhost:8080/games/1/batterRecord/user/2
/*
6. 유저1이 자기가 먼저 수비니까 pitch하기 (이 순서로는 half_inning 바뀌기 까지 유저2는 pitch 하면 500에러)
http://localhost:8080/games/1/pitch/user/1 post

7. pitch 결과 받기 유저2
http://localhost:8080/games/1/pitchResult/user/2  get (유저1도 가능)

8. 유저1이 자기 pitch 차례일 때 halfInning 끝내기
http://localhost:8080/games/1/halfInning/user/1 post ( 유저2는 자기 pitch 차례에 가능)
*/

export default API;