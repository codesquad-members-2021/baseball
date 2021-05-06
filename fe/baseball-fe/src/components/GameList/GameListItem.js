import styled from "styled-components";

function GameListItem({ match, idx }) {
  return (
    <StyledGameListItem>
      <GameNumber>Game {idx + 1}</GameNumber>
      <MatchInformation>
        <TeamHome>{match.home.name} </TeamHome>
        vs.
        <TeamAway>{match.away.name}</TeamAway>
      </MatchInformation>
    </StyledGameListItem>
  );
}

export default GameListItem;

const StyledGameListItem = styled.li`
  color: black;
  list-style: none;
  text-align: center;
  background-color: #b3b3b3;
  border-radius: 10px;
  height: 5rem;
  font-weight: 600;
  padding: 0.5rem;

    & + & {
        margin-top: 1rem;
    }
`;

const GameNumber = styled.div`
  color: red;
`;

const MatchInformation = styled.div`
  & > div {
    display: inline-block;
    font-size: 2rem;
    width: calc(100% / 3);

    &:hover {
      color: red;
    }
  }
`;

const TeamHome = styled.div``;

const TeamAway = styled.div``;
