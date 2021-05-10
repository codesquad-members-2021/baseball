const END_POINT = "http://ec2-13-125-90-225.ap-northeast-2.compute.amazonaws.com:8080";

const API = {
  get: {
    teams: async () => {
      const response = await fetch(`/teams`);
      return response.json();
    },

  },
  post: {}
};

const customFetch = async (...param) => {
  const fetchData = await (await fetch(...param)).json();
  if (fetchData.statusCode >= 400 || fetchData.body === null) throw { status: 'fail' };
  return fetchData;
};

export default API;