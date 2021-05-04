import React from 'react'
import HeaderRight from "Components/GamePage/GamePageHeader/HeaderRight"
import HeaderLeft from "Components/GamePage/GamePageHeader/HeaderLeft"
import styled from "styled-components";

const GamePageHeader = () => {
  return (
    <Header>
      <HeaderLeft />
      <HeaderRight />
    </Header>
  )
}

const Header = styled.div`
    width:100%;
    height:10rem;
    color:white;
    background:black;
    opacity:0.9;
    display:flex;
    justify-content:space-between;
    border-bottom:#e2e2e2 0.1rem solid;
`;

export default GamePageHeader;
