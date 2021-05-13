// import { useContext } from "react";
// import { GlobalContext } from "util/context.js";
// import { GlobalAction } from "util/action.js";
import { useState } from 'react';
import Message from "./Message.js";
import GameList from "components/GameList/GameList.js";
import styled from "styled-components";

function MainPage() {
  const [message, setMessage] = useState('참가할 팀을 선택하세요!');

  return (
    <StyledMainPage>
      <div>BASEBALL GAME ONLINE</div>
      <Message message={message}/>
      <GameList setMessage={setMessage}/>
    </StyledMainPage>
  );
}

export default MainPage;

const StyledMainPage = styled.div`
  width: 100%;
  height: 100%;
  box-shadow: 0 0 0 1px blue inset;
  background-color: black;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;

  & > div {
    color: #fff;
    font-weight: 600;
    font-size: 2.5rem;
  }
`;
