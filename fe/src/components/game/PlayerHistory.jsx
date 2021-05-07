import React from "react";
import styled from "styled-components";

const PlayerHistory = (props) => {
  return (
    <PlayerHistoryContainer>
      {/*styled-component*/}
      <div>
        {"7"}번 타자 {"류현진"}
      </div>
      <ul>
        <li>
          {/*map 돌릴 예정*/}
          <span>1</span>
          <span>스트라이크</span>
          <span>
            S{"2"} B{"2"}
          </span>
        </li>
        <li>
          <span>2</span>
          <span>스트라이크</span>
          <span>
            S{"2"} B{"2"}
          </span>
        </li>
        <li>
          <span>3</span>
          <span>스트라이크</span>
          <span>
            S{"2"} B{"2"}
          </span>
        </li>
        <li>
          <span>4</span>
          <span>스트라이크</span>
          <span>
            S{"2"} B{"2"}
          </span>
        </li>
        <li>
          <span>5</span>
          <span>스트라이크</span>
          <span>
            S{"2"} B{"2"}
          </span>
        </li>
      </ul>
    </PlayerHistoryContainer>
  );
};

export default PlayerHistory;

const PlayerHistoryContainer = styled.div``;
