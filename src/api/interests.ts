import axios from "axios";

const API_URL = "http://localhost:8080";

export const getInterests = (page: number = 0, size: number = 10): Promise<any> => {
  return axios.get(`${API_URL}/interests`, { params: { page, size } });
};
