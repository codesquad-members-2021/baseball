const url = 'http://13.124.70.38:8080';
const API = {
	get: {
		teamList: async () => {
			const response = await fetch(`${url}/games`);
			return response.json();
		},
	},
	post: {},
	patch: {
		initGame: async (gameId) => {
			const response = await fetch(`${url}/games/${gameId}`, {
				method: 'PATCH',
				headers: {
					'Content-Type': 'application/json',
					'API-Key': 'secret',
				},
			});
			return response.json();
		},
	},
};
export default API;
