const url = 'http://ec2-3-35-119-77.ap-northeast-2.compute.amazonaws.com';
const API = {
	get: {
		teamList: async () => {
			const response = await fetch(`${url}/games`);
			return response.json();
		},
		initGame: async (gameId) => {
			const response = await fetch(`${url}/games/${gameId}`);
			return response.json();
		},
	},
	post: {
		pitch: async (gameId) => {
			const response = await fetch(`${url}/games/${gameId}/pitch`, {
				method: 'post',
				headers: {
					'Content-Type': 'application/json',
					'API-Key': 'secret',
				},
			});
			return response.json();
		},
	},
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
