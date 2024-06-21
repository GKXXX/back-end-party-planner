import React, { ReactNode } from "react";

interface MainProps {
  children: ReactNode;
}

const Main: React.FC<MainProps> = ({ children }) => {
  return <main className="flex-grow container mx-auto p-4">{children}</main>;
};

export default Main;
