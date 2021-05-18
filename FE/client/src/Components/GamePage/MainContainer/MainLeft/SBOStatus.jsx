import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import styled from "styled-components";

const SBOStatus = () => {
  const { currentSBData, outState } = useContext(GamePageContext);

  return (
    <SBOBoard>
      <CircleListDiv>
        <SBOspan>S</SBOspan>
        <CircleList>
          {currentSBData && Array.from({ length: 2 }).map((_, index) => (
            <SBOCircle key={`yellow-${index}`}
              color="yellow"
              background={currentSBData.strike >= index + 1}
            />
          ))}
        </CircleList>
      </CircleListDiv>
      <CircleListDiv>
        <SBOspan>B</SBOspan>
        <CircleList>
          {currentSBData && Array.from({ length: 3 }).map((_, index) => (
            <SBOCircle key={`green-${index}`}
              color="green"
              background={currentSBData.ball >= index + 1}
            />
          ))}
        </CircleList>
      </CircleListDiv>
      <CircleListDiv>
        <SBOspan>O</SBOspan>
        <CircleList>
          {Array.from({ length: 2 }).map((_, index) => (
            <SBOCircle key={`red-${index}`}
              color="red"
              background={outState >= index + 1} />
          ))}
        </CircleList>
      </CircleListDiv>
    </SBOBoard>
  );
};

const SBOBoard = styled.div`
  display: flex;
  flex-direction: column;
  padding: 2rem 2rem;
`;

const CircleListDiv = styled.div`
  display: flex;
  align-items: center;
`;

const SBOspan = styled.span`
  width: 1.5rem;
  font-size: 1rem;
`;

const CircleList = styled.ul`
  display: flex;
  gap: 0.3rem;
`;

const SBOCircle = styled.li`
  border-radius: 70%;
  width: 1rem;
  height: 1rem;
  background: ${({ background, color }) => background && color};
  list-style: none;
  border: 0.1rem solid ${({ color }) => color};
`;

export default SBOStatus;