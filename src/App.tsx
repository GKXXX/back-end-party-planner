import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import Main from "./components/Main";
import Login from "./components/Login";
import Signup from "./components/SignUp";
import EventsList from "./components/EventsList";
import EventDetails from "./components/EventDetails";
import AddEvent from "./components/AddEvent";

const App: React.FC = () => {
  return (
    <Router>
      <div className="flex flex-col min-h-screen overflow-hidden">
        <Header />
        <Main>
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/events" element={<EventsList />} />
            <Route path="/events/:id" element={<EventDetails />} />
            <Route path="/add-event" element={<AddEvent />} />
            <Route
              path="/"
              element={
                <h1 className="text-3xl font-bold underline">Welcome Home!</h1>
              }
            />
          </Routes>
        </Main>
        <Footer />
      </div>
    </Router>
  );
};

export default App;
