import React from 'react';
import Home from 'Components/Home';
import GamePage from "Components/GamePage";
import { Router, Route } from "utils/Router";

const Page = () => {
  return (
    <Router>
      <Route path="/" component={Home} />
      <Route path="/GamePage" component={GamePage} />
    </Router>
  );
};

export default Page;
