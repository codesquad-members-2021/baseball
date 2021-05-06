import { useContext } from 'react';
import styled from "styled-components";
import { GlobalContext } from "util/context.js";
import { GlobalAction } from 'util/action.js';

function GameListItem({ match, idx, isLoading }) {
  const { globalDispatch } = useContext(GlobalContext);

  const handleClickTeam = (teamName) => {
    globalDispatch({
        type: GlobalAction.SELECT_TEAM,
        payload: { gameId: match.id, playTeam: teamName }
    });
  }

  return (
    isLoading
    ? <StlyedLoadingListItem/>
    : <StyledGameListItem>
        <GameNumber>Game {idx + 1}</GameNumber>
        <MatchInformation>
            <TeamHome onClick={() => handleClickTeam(match.home.name)}>
              {match.home.name}
            </TeamHome>
            vs.
            <TeamAway onClick={() => handleClickTeam(match.away.name)}>
              {match.away.name}
            </TeamAway>
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

const StlyedLoadingListItem = styled.li`
  list-style: none;
  text-align: center;
  background-color: #b3b3b3;
  border-radius: 10px;
  height: 5rem;
  padding: 0.5rem;

    & + & {
        margin-top: 1rem;
    }
`
