import axios from "axios";

const API_URL = "http://localhost:8080";

export const getUsers = (page: number = 0, size: number = 10): Promise<any> => {
  return axios.get(`${API_URL}/users`, { params: { page, size } });
};

export const getUserById = (id: string): Promise<any> => {
  return axios.get(`${API_URL}/users/${id}`);
};

export const getUserByUsername = (username: string): Promise<any> => {
  return axios.get(`${API_URL}/users/${username}`);
};

export const updateUser = (id: string, userData: any): Promise<any> => {
  return axios.put(`${API_URL}/users/${id}`, userData);
};

export const deleteUser = (id: string): Promise<any> => {
  return axios.delete(`${API_URL}/users/${id}`);
};
