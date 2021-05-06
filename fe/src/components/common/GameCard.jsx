import styled from "styled-components";
const GameCard = ({ game, idx }) => {
  console.log(game);
  const [home, away] = game;
  return (
    <GameCardLayout>
      <GameTeamNameLayout>{home}</GameTeamNameLayout>
      <GameVersusLayout>vs</GameVersusLayout>
      <GameTeamNameLayout>{away}</GameTeamNameLayout>
    </GameCardLayout>
  );
};

const GameCardLayout = styled.div`
  display: flex;
  justify-content: space-between;
  padding: 3% 10%;
  border: 1px solid black;
  background-color: white;
  font-size: 3rem;
  border-radius: 20px;
  text-align: center;

  & + & {
    margin-top: 10px;
  }
`;

const GameVersusLayout = styled.span`
  /* outline: red solid 1px; */
  width: 100%;
  color: #5f5d5d;
`;
const GameTeamNameLayout = styled.span`
  /* outline: red solid 1px; */
  width: 100%;
`;

export default GameCard;
