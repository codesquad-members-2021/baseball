import styled from "styled-components";
const Game = () => {
  return (
    <GameWrapper>
      <GameTitle>GAME 1</GameTitle>
      <GameBody>
        <TeamName>Captain</TeamName>
        <div style={{ fontSize: "1.5rem" }}>VS</div>
        <TeamName>Marvel</TeamName>
      </GameBody>
    </GameWrapper>
  );
};
const GameWrapper = styled.div`
  background-color: rgb(180, 180, 180);
  padding: 1rem 0;
  border-radius: 0.5rem;
  & + & {
    margin-top: 1rem;
  }
`;
const GameTitle = styled.h3`
  text-align: center;
  font-size: 1rem;
  color: red;
`;
const GameBody = styled.div`
  margin: 1.5rem 0;
  display: flex;
  align-items: center;
`;
const TeamName = styled.div`
  flex: 1;
  font-size: 2rem;
  text-align: center;
`;

export default Game;
