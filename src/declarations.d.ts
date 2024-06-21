declare module '../api/comments' {
   export const getComments: (page?: number, size?: number) => Promise<any>;
   export const getCommentById: (id: string) => Promise<any>;
   export const createComment: (commentData: any) => Promise<any>;
   export const updateComment: (id: string, commentData: any) => Promise<any>;
   export const deleteComment: (id: string) => Promise<any>;
 }
 
 declare module '../api/events' {
   export const getEvents: (page: number, size: number) => Promise<any>;
   export const getEventById: (id: string) => Promise<any>;
   export const createEvent: (eventData: any) => Promise<any>;
   export const updateEvent: (id: string, eventData: any) => Promise<any>;
   export const deleteEvent: (id: string) => Promise<any>;
   export const getPaidEvents: (isPaid: boolean, page?: number, size?: number) => Promise<any>;
   export const searchEvents: (
     location: string,
     id_interest: string,
     isPaid: boolean,
     page?: number,
     size?: number
   ) => Promise<any>;
 }
 
 declare module '../api/interests' {
   export const getInterests: (page?: number, size?: number) => Promise<any>;
 }
 
 declare module '../api/ratings' {
   export const getRatings: (page?: number, size?: number) => Promise<any>;
   export const getRatingById: (id: string) => Promise<any>;
   export const createRating: (ratingData: any) => Promise<any>;
   export const updateRating: (id: string, ratingData: any) => Promise<any>;
   export const deleteRating: (id: string) => Promise<any>;
 }
 
 declare module '../api/users' {
   export const getUsers: (page?: number, size?: number) => Promise<any>;
   export const getUserById: (id: string) => Promise<any>;
   export const getUserByUsername: (username: string) => Promise<any>;
   export const updateUser: (id: string, userData: any) => Promise<any>;
   export const deleteUser: (id: string) => Promise<any>;
 }
 