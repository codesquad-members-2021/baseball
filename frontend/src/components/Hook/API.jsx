const url = 'http://13.124.70.38:8080';
const API = {
	get: {
		teamList: async () => {
			const response = await fetch(`${url}/games`);
			return response.json();
		},
		initData: async (gameId) => {
			const response = await fetch(`${url}/games/${gameId}`);
			return response.json();
		},
	},
	post: {},
};
export default API;

// fetch(url)
//     .then(response => response.json())
//     .then(jsondata => console.log(jsondata))
