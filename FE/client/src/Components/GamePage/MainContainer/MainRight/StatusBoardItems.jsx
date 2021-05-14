import { GamePageContext } from "Components/GamePage";
import React, { useContext } from "react";
import styled from "styled-components";

const StatusBoardItems = ({ record, index, recordLength }) => {
  const { inGameData, currentSBData, currentPlayAction } = useContext(GamePageContext);

  // console.log("여기서찍는SB", currentSBData);
  // console.log(1, currentPlayAction)
  const { action, strike, ball } = record;

  return (
    <StatusBoardItem>

      {action === 'strike' && <><NumberCircle>{(recordLength - index)}</NumberCircle>스트라이크</>}
      {action === 'ball' && <><NumberCircle>{(recordLength - index)}</NumberCircle>볼</>}
      {action === 'hit' && <><FinishItem>안타 !</FinishItem></>}

      <StrikeBallStatus>{action !== 'hit' && `S${strike} B${ball}`}</StrikeBallStatus>
    </StatusBoardItem>
  );
};

const FinishItem = styled.div`
  margin:auto;
  color: #47abc4;
  font-weight:700;
`;

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
