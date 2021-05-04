import axios from "axios";

export const instance = axios.create({
  baseURL: "http://localhost:8080/",
  timeout: 1000,
  headers: { "Content-Type": "application/json;charset=UTF-8" },
});

export default instance;
