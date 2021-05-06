import styled from "styled-components";
const GameMessage = () => {
  return <GameMessageLayout>참가할 게임을 선택하세요!</GameMessageLayout>;
};

const GameMessageLayout = styled.div`
  color: white;
  font-size: 3rem;
  font-weight: bold;
  
  display: flex;
  justify-content: center;

  padding-top: 10%;
`;

export default GameMessage;
