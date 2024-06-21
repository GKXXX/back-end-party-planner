import axios from "axios";

const API_URL = "http://localhost:8080";

export const getRatings = (page: number = 0, size: number = 10): Promise<any> => {
  return axios.get(`${API_URL}/ratings`, { params: { page, size } });
};

export const getRatingById = (id: string): Promise<any> => {
  return axios.get(`${API_URL}/ratings/${id}`);
};

export const createRating = (ratingData: any): Promise<any> => {
  return axios.post(`${API_URL}/ratings`, ratingData);
};

export const updateRating = (id: string, ratingData: any): Promise<any> => {
  return axios.put(`${API_URL}/ratings/${id}`, ratingData);
};

export const deleteRating = (id: string): Promise<any> => {
  return axios.delete(`${API_URL}/ratings/${id}`);
};
