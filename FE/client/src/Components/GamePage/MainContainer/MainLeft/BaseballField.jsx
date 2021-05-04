import React from "react";
import styled from "styled-components";

const BaseballField = () => {
  return (
    <BaseballFieldWrapper>
      <div>Hi I'm field</div>
    </BaseballFieldWrapper>
  );
};

const BaseballFieldWrapper = styled.div`
  color: white;
  padding: 2rem;
`;

export default BaseballField;
