import React, { createContext, useEffect, useState } from 'react';
import Home from 'Components/Home';
import GamePage from "Components/GamePage";
import BeemoRouter from "utils/BeemoRouter";
import io from 'socket.io-client';

export const PageContext = createContext();
const socket = io.connect('http://localhost:3001');

const Page = () => {
  const { Router, Route, push } = BeemoRouter();
  const [userState, setUserState] = useState(null);

  useEffect(() => {
    const connectSocket = () => {
      socket.emit('init');
      socket.on('matchingGame', ({ gamePageUrl, gameId, teamKind }) => {
        push(gamePageUrl); // GamePage로 이동
        setUserState({ gameId, teamKind });
      });
    };
    connectSocket();
  }, []);

  return (
    <Router>
      <PageContext.Provider value={{ socket }}>
        <Route path="/" >
          <Home {...{ socket }} />
        </Route>
        <Route path="/GamePage">
          <GamePage {...{ userState }} />
        </Route>
      </PageContext.Provider>
    </Router>
  );
};

export default Page;
