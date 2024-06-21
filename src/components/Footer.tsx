import React from "react";

const Footer: React.FC = () => {
  return (
    <footer className="bg-blue-500 text-white p-4 mt-auto">
      <div className="container mx-auto text-center">
        &copy; {new Date().getFullYear()} Party Planner.
      </div>
    </footer>
  );
};

export default Footer;
