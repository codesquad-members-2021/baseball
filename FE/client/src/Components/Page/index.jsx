import React, { createContext, useEffect, useState } from 'react';
import Home from 'Components/Home';
import GamePage from "Components/GamePage";
import { Router, Route } from "utils/BeemoRouter";
import io from 'socket.io-client';

export const PageContext = createContext();
const socket = io.connect('http://localhost:3001');

const Page = () => {
  const [playerId, setPlayerId] = useState();

  useEffect(() => {
    const connectSocket = () => {
      socket.emit('init');
      socket.on('playerId', (playerId) => {
        setPlayerId(playerId);
      });
    };
    connectSocket();
  }, []);

  useEffect(() => {
    console.log(playerId)
  }, [playerId]);

  return (

    <Router>
      <PageContext.Provider value={{ playerId, socket }}>
        <Route path="/" component={Home} />
        <Route path="/GamePage" component={GamePage} />
      </PageContext.Provider>
    </Router>
  );
};

export default Page;
