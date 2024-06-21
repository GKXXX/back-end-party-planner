import React from "react";
import { Link } from "react-router-dom";

const Header: React.FC = () => {
  return (
    <header className="bg-blue-500 text-white p-4">
      <div className="container mx-auto flex justify-between items-center">
        <h1 className="text-xl font-bold">
          <Link to="/">Party Planner</Link>
        </h1>
        <nav>
          <Link to="/events" className="px-2">
            Events
          </Link>
          <Link to="/add-event" className="px-2">
            Add Event
          </Link>
          <Link to="/login" className="px-2">
            Login
          </Link>
          <Link to="/signup" className="px-2">
            Sign Up
          </Link>
        </nav>
      </div>
    </header>
  );
};

export default Header;
