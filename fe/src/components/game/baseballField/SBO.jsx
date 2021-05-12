import React, { useContext } from "react";
import styled from "styled-components";
import { GlobalContext } from "../../../App";

const SBO = (props) => {
  const { currS, currB, currO } = useContext(GlobalContext);

  return (
    <ul>
      <SBOItem>
        <SBOKind>S</SBOKind>
        <SBOCount>{Array.from({ length: currS }).map(() => "🟡")}</SBOCount>
      </SBOItem>
      <SBOItem>
        <SBOKind>B</SBOKind>
        <SBOCount>
          {Array(currB)
            .fill(0)
            .map(() => "🟢")}
        </SBOCount>
      </SBOItem>
      <SBOItem>
        <SBOKind>O</SBOKind>
        <SBOCount>{Array.from({ length: currO }).map(() => "🔴")}</SBOCount>
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
