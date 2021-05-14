import React from "react";
import styled from "styled-components";

function Message({ message }) {
  return (
    <StyledMessage>
      <div>{message}</div>
    </StyledMessage>
  );
}

export default Message;

const StyledMessage = styled.div`
  & > div {
    margin-top: 2rem;
    font-size: 1.5rem;
  }
`;
