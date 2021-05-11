import React, { createContext, useEffect } from 'react';
import Home from 'Components/Home';
import GamePage from "Components/GamePage";
import { Router, Route } from "utils/BeemoRouter";
import io from 'socket.io-client';

export const PageContext = createContext();
const socket = io.connect('http://localhost:3001');

const Page = () => {
  useEffect(() => {
    const connectSocket = () => {
      socket.emit('init');
    };
    connectSocket();
  }, []);

  return (
    <Router>
      <PageContext.Provider value={{ socket }}>
        <Route path="/" component={Home} />
        <Route path="/GamePage" component={GamePage} />
      </PageContext.Provider>
    </Router>
  );
};

export default Page;
