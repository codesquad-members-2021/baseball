import axios from "./axios";

export const loginService = {
  postLogin: async (loginInfo: { id: string; pw: string }) => {
    const response = await axios.post("/api/login", loginInfo);
    return response;
  },
};
