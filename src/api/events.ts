import axios from "axios";
import { Event, Comment, Rating } from "../types";

const API_URL = "http://localhost:8080";

export const getEvents = (page = 0, size = 10): Promise<{ data: Event[] }> => {
  return axios.get(`${API_URL}/events`, {
    params: { page, size },
  }).then(response => ({ data: response.data.content })); // Extract content here
};

export const getEventById = (id: string): Promise<{ data: Event }> => {
  return axios.get(`${API_URL}/events/${id}`);
};

export const createEvent = (eventData: Omit<Event, 'id'>): Promise<{ data: Event }> => {
  return axios.post(`${API_URL}/events`, eventData);
};

export const getComments = (eventId: string, page = 0, size = 10): Promise<{ data: Comment[] }> => {
  return axios.get(`${API_URL}/events/${eventId}/comments`, {
    params: { page, size },
  });
};

export const addComment = (eventId: string, commentData: Pick<Comment, 'text'>): Promise<{ data: Comment }> => {
  return axios.post(`${API_URL}/events/${eventId}/comments`, commentData);
};

export const getRatings = (eventId: string, page = 0, size = 10): Promise<{ data: Rating[] }> => {
  return axios.get(`${API_URL}/events/${eventId}/ratings`, {
    params: { page, size },
  });
};

export const addRating = (eventId: string, ratingData: Pick<Rating, 'value'>): Promise<{ data: Rating }> => {
  return axios.post(`${API_URL}/events/${eventId}/ratings`, ratingData);
};
