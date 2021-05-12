import styled from "styled-components";
const GameCard = ({ game, idx }) => {
  const [home, away] = game;

  return (
    <GameCardLayout>
      <GameCardRow>
        <GameNumber>GAME {idx}</GameNumber>
      </GameCardRow>

      <GameCardRow>
        <TeamName>{home}</TeamName>
        <Versus>vs</Versus>
        <TeamName>{away}</TeamName>
      </GameCardRow>
    </GameCardLayout>
  );
};

const GameCardLayout = styled.div`
  border: 1px solid black;
  background-color: white;
  border-radius: 20px;
  text-align: center;
  cursor: pointer;

  & + & {
    margin-top: 10px;
  }

  &:hover {
    background-color: #fff99e;
  }
`;

const GameCardRow = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 10px 0px;
`;
const GameNumber = styled.div`
  width: 100%;
  font-size: 1.5rem;
  color: red;
`;

const Versus = styled.span`
  width: 100%;
  color: #5f5d5d;
  font-size: 2rem;
  padding: 30px 0px;
`;
const TeamName = styled.span`
  width: 100%;
  font-size: 3rem;
  padding: 20px 0px;
  &:hover {
    color: red;
  }
`;

export default GameCard;
