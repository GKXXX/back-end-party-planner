import React, { useEffect, useState } from "react";
import {
  getEventById,
  getComments,
  getRatings,
  addComment,
  addRating,
} from "../api/events";
import { useParams } from "react-router-dom";
import { Event, Comment, Rating } from "../types";

const EventDetails: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const [event, setEvent] = useState<Event | null>(null);
  const [comments, setComments] = useState<Comment[]>([]);
  const [ratings, setRatings] = useState<Rating[]>([]);
  const [commentText, setCommentText] = useState("");
  const [ratingValue, setRatingValue] = useState(0);

  useEffect(() => {
    if (id) {
      const fetchEventDetails = async () => {
        try {
          const eventResponse = await getEventById(id);
          setEvent(eventResponse.data);
          const commentsResponse = await getComments(id, 0, 10);
          setComments(commentsResponse.data);
          const ratingsResponse = await getRatings(id, 0, 10);
          setRatings(ratingsResponse.data);
        } catch (error) {
          console.error("Error fetching event details", error);
        }
      };

      fetchEventDetails();
    }
  }, [id]);

  const handleAddComment = async () => {
    if (id) {
      try {
        const response = await addComment(id, { text: commentText });
        setComments([...comments, response.data]);
        setCommentText("");
      } catch (error) {
        console.error("Error adding comment", error);
      }
    }
  };

  const handleAddRating = async () => {
    if (id) {
      try {
        const response = await addRating(id, { value: ratingValue });
        setRatings([...ratings, response.data]);
        setRatingValue(0);
      } catch (error) {
        console.error("Error adding rating", error);
      }
    }
  };

  if (!event) {
    return <p>Loading event details...</p>;
  }

  return (
    <div>
      <h2>{event.name}</h2>
      <p>{event.description}</p>
      <h3>Comments</h3>
      <ul>
        {comments.map((comment) => (
          <li key={comment.id}>{comment.text}</li>
        ))}
      </ul>
      <textarea
        value={commentText}
        onChange={(e) => setCommentText(e.target.value)}
        placeholder="Add a comment"
      />
      <button onClick={handleAddComment}>Add Comment</button>

      <h3>Ratings</h3>
      <ul>
        {ratings.map((rating) => (
          <li key={rating.id}>Rating: {rating.value}</li>
        ))}
      </ul>
      <input
        type="number"
        value={ratingValue}
        onChange={(e) => setRatingValue(parseInt(e.target.value))}
        min="1"
        max="5"
        placeholder="Add a rating"
      />
      <button onClick={handleAddRating}>Add Rating</button>
    </div>
  );
};

export default EventDetails;
