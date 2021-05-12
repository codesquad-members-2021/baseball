import React from "react";
import HeaderRight from "./HeaderRight";
import HeaderLeft from "./HeaderLeft";
import styled from "styled-components";

const GamePageHeader = () => {
  return (
    <Header>
      <HeaderLeft />
      <HeaderRight />
    </Header>
  );
};

const Header = styled.div`
  width: 100%;
  height: 22%;
  color: white;
  background: black;
  opacity: 0.9;
  display: flex;
  justify-content: space-between;
  border-bottom: #e2e2e2 0.1rem solid;
`;

export default GamePageHeader;