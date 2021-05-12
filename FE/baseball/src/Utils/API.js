import axios from "axios";

const api = axios.create({
	baseURL: "http://13.209.36.131:8080/"
})

const getAPI = {
	main: () => api.get("main"),
	game: (gameId) => api.get(`games/${gameId}`),
	score: (gameId) => api.get(`games/${gameId}/scores`),
	squads: (gameId) => api.get(`games/${gameId}/squads`)
}

const putAPI = {
	endInning: ({ gameId, inningNumber, body }) => api.put(`games/${gameId}/${inningNumber}`, body),
	pitch: (gameId, body) => api.put(`games/${gameId}`, body),
}

export { getAPI, putAPI }