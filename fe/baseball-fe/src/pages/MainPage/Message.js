import React from "react";
import styled from "styled-components";

function Message() {
  return (
    <StyledMessage>
      <div>참가할 게임을 선택하세요!</div>
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
