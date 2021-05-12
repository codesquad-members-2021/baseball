import React from "react";
import styled from "styled-components";

const SBOStatus = () => {
  return (
    <SBOBoard>
      <CircleListDiv>
        <SBOspan>S</SBOspan>
        <CircleList>
          {Array.from({ length: 2 }).map((circle) => (
            <SBOCircle color="yellow" />
          ))}
        </CircleList>
      </CircleListDiv>
      <CircleListDiv>
        <SBOspan>B</SBOspan>
        <CircleList>
          {Array.from({ length: 3 }).map((circle) => (
            <SBOCircle color="green" />
          ))}
        </CircleList>
      </CircleListDiv>
      <CircleListDiv>
        <SBOspan>O</SBOspan>
        <CircleList>
          {Array.from({ length: 2 }).map((circle) => (
            <SBOCircle color="red" />
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
  /* background: ${({ color }) => color}; */
  list-style: none;
  border: 0.1rem solid ${({ color }) => color};
`;

export default SBOStatus;