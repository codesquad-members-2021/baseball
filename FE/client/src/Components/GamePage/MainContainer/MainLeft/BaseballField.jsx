import React from "react";
import styled from "styled-components";

const BaseballField = () => {
  return (
    <BaseballFieldBackground>
      <div>Hi I'm field</div>
    </BaseballFieldBackground>
  );
};

const BaseballFieldBackground = styled.div`
  color: white;
`;

export default BaseballField;
