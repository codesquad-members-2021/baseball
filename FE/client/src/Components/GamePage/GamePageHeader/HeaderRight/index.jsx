import React from "react";
import styled from "styled-components";
import CurrentPlayer from "Components/GamePage/GamePageHeader/HeaderRight/CurrentPlayer";

const HeaderRight = () => {
  return (
    <HeaderRightDiv>
      <CurrentPlayer
        type="투수"
        name="최동원"
        description="#39"
      ></CurrentPlayer>
      <CurrentPlayer
        type="타자"
        name="류현진"
        description="1타석 0안타"
      ></CurrentPlayer>
    </HeaderRightDiv>
  );
};

const HeaderRightDiv = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  border-left: #e2e2e2 0.1rem solid;
  padding: 0.5rem 0.8rem;
  justify-content: space-around;
  width: 20%;
`;

export default HeaderRight;
