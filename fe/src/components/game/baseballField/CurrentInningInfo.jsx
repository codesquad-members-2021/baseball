import React from "react";
import styled from "styled-components";
const CurrentInningInfo = ({ inning }) => {
  return (
    <InningInfoBox>
      <p>{`${inning.inningNumber}회${inning.cycle} ${inning.role}`}</p>
    </InningInfoBox>
  );
};

export default CurrentInningInfo;

const InningInfoBox = styled.div`
  width: 150px;
  text-align: center;
`;
