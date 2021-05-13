const END_POINT =
  "http://ec2-13-125-90-225.ap-northeast-2.compute.amazonaws.com";

const API = {
  get: {
    teams: () => customFetch(`${END_POINT}/teams`),
    games: () => customFetch(`${END_POINT}/games`),
    scores: (gameId) => customFetch(`${END_POINT}/games/${gameId}/scores`),
    records: (teamId) => customFetch(`${END_POINT}/teams/${teamId}/records`),
    inGameDatas: (gameId) =>
      customFetch(`${END_POINT}/games/${gameId}/members`),
  },
  post: {},
};

const customFetch = async (...param) => {
  const fetchData = await (await fetch(...param)).json();
  if (fetchData.statusCode >= 400 || fetchData.body === null)
    throw { status: "fail" };
  return fetchData;
};

export default API;
