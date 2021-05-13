import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import styled from "styled-components";

const StatusBoardItems = (props) => {
  const { inGameData, currentSBData } = useContext(GamePageContext);
  console.log(
    "어레이프롬",
    currentSBData &&
      Array.from({
        length: currentSBData.strike + currentSBData.ball,
      })
  );
  console.log("여기서찍는SB", currentSBData);
  return (
    <>
      {currentSBData &&
        Array.from({ length: currentSBData.strike + currentSBData.ball }).map(
          (_, index) => (
            <StatusBoardItem>
              <NumberCircle>{index + 1}</NumberCircle>스트라이크
              <StrikeBallStatus>{`S${currentSBData.strike} B${currentSBData.ball}`}</StrikeBallStatus>
            </StatusBoardItem>
          )
        )}
    </>
  );
};

const StatusBoardItem = styled.div`
  display: flex;
  margin: 0.3rem 0.2rem;
  justify-content: space-between;
`;
const NumberCircle = styled.div`
  width: 1.5rem;
  height: 1.5rem;
  color: black;
  text-align: Center;
  border-radius: 70%;
  font-weight: bold;
  background: white;
  margin-right: 0.3rem;
`;

const StrikeBallStatus = styled.div`
  color: #e2e2e2;
`;

export default StatusBoardItems;
