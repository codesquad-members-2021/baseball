import React from "react";
import styled from "styled-components";

const SBO = (props) => {
  return (
    <ul>
      <SBOItem>
        <SBOKind>S</SBOKind>
        <SBOCount>🟡🟡</SBOCount>
      </SBOItem>
      <SBOItem>
        <SBOKind>B</SBOKind>
        <SBOCount>🟢🟢🟢</SBOCount>
      </SBOItem>
      <SBOItem>
        <SBOKind>O</SBOKind>
        <SBOCount>🔴🔴</SBOCount>
      </SBOItem>
    </ul>
  );
};

export default SBO;

const SBOItem = styled.li`
  display: flex;
  & div {
    height: 20px;
  }
`;

const SBOKind = styled.div`
  width: 20px;
  text-align: center;
`;

const SBOCount = styled.div`
  width: 80px;
`;
