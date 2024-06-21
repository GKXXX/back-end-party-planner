export interface Event {
  id: string;
  name: string;
  description: string;
  date: string; // Assuming date is a string, adjust if necessary
  location: string;
}

export interface Comment {
  id: string;
  text: string;
  // Add other fields as necessary
}

export interface Rating {
  id: string;
  value: number;
  // Add other fields as necessary
}
