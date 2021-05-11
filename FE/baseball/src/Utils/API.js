import axios from "axios";

const api = axios.create({
	baseURL: "http://13.209.36.131:8080/"
})

const getAPI = {
	main: () => api.get("main"),
	game: (gameID) => api.get(`games/${gameID}`),
	score: (gameID) => api.get(`games/${gameID}/scores`),
	squads: (gameID) => api.get(`games/${gameID}/squads`)
}

const putAPI = {
	endInning: ({ gameID, inningNumber, body }) => api.put(`games/${gameID}/${inningNumber}`, body),
	pitch: (gameID, body) => api.put(`games/${gameID}`, body),
}

export { getAPI, putAPI }