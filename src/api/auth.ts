import axios from "axios";

const API_URL = "http://localhost:8080";

export const login = async (username, password) => {
  try {
    const response = await axios.post(`${API_URL}/auth/connect`, { username, password });
    if (response.status === 200) {
      localStorage.setItem('token', response.data);
    }
    return response;
  } catch (error) {
    console.error("Login error", error);
    throw error;
  }
};

export const register = async (userData) => {
  try {
    return await axios.post(`${API_URL}/auth/register`, userData);
  } catch (error) {
    console.error("Registration error", error);
    throw error;
  }
};

export const getToken = () => localStorage.getItem('token');

axios.interceptors.request.use(
  (config) => {
    const token = getToken();
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);
