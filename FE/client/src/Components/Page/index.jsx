import React, { useEffect } from 'react';
import Home from 'Components/Home';
import GamePage from "Components/GamePage";
import { Router, Route } from "utils/BeemoRouter";
import io from 'socket.io-client';
import API from 'utils/API';
const Page = () => {

  useEffect(() => {
    const socket = io.connect('http://localhost:3001');
    const connectSocket = () => {
      socket.emit('init', { name: 'bella' });
      socket.on('welcome', (msg) => {
        console.log(msg);
      });
    };
    connectSocket();
  }, []);

  useEffect(() => {
    const getTeams = async () => {
      const teams = await API.get.teams();
      console.log(teams);
    }
    getTeams();
  }, []);

  return (
    <Router>
      <Route path="/" component={Home} />
      <Route path="/GamePage" component={GamePage} />
    </Router>
  );
};

export default Page;
