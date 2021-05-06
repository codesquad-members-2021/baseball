import React from 'react';
import Home from 'Components/Home';
import GamePage from "Components/GamePage";
import { Route } from "react-router-dom";

const Page = () => {
  return (
    <>
      <Route path="/" component={Home} exact />
      <Route path="/GamePage" component={GamePage} />
      {/* <Home></Home>
      <GamePage></GamePage> */}
    </>
  );
};

export default Page;
