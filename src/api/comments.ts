import axios from "axios";

const API_URL = "http://localhost:8080";

export const getComments = (page: number = 0, size: number = 10): Promise<any> => {
  return axios.get(`${API_URL}/comments`, { params: { page, size } });
};

export const getCommentById = (id: string): Promise<any> => {
  return axios.get(`${API_URL}/comments/${id}`);
};

export const createComment = (commentData: any): Promise<any> => {
  return axios.post(`${API_URL}/comments`, commentData);
};

export const updateComment = (id: string, commentData: any): Promise<any> => {
  return axios.put(`${API_URL}/comments/${id}`, commentData);
};

export const deleteComment = (id: string): Promise<any> => {
  return axios.delete(`${API_URL}/comments/${id}`);
};


