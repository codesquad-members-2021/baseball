let url = 'https://890e124d-c97a-4c91-a91a-0d19d727c1d6.mock.pstmn.io';
const API = {
	get: {
		teamList: async () => {
			const response = await fetch(`${url}/games`);
			return response.json();
		},
	},
	post: {},
};

export default API;

// fetch("https://example.com")
//     .then(response => response.json())
//     .then(jsondata => console.log(jsondata))
