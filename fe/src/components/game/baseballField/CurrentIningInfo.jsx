import React from "react";
import styled from "styled-components";
const CurrentIningInfo = (props) => {
  return (
    <IningInfoBox>
      <p>2회초 수비</p>
    </IningInfoBox>
  );
};

export default CurrentIningInfo;

const IningInfoBox = styled.div`
  width: 150px;
  text-align: center;
`;
