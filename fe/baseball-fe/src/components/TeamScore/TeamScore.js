import { useContext } from 'react';
import styled from 'styled-components';
import { GlobalContext, GameContext } from 'util/context.js';

function TeamScore({ className }) {
  const { globalState } = useContext(GlobalContext);
  const { gameState } = useContext(GameContext);

  return (
    <StyledTeamScore className={className}>
      <div className='title'>BASEBALL GAME ONLINE</div>
      <div className='score-board'>
        <div className='away-team'>
          {gameState.away.name}
          {globalState.playTeam === gameState.away.name &&
            <div className='player'>Player</div>}
        </div>
        <span className='score'>{gameState.away.score}</span>
        vs
        <span className='score'>{gameState.home.score}</span>
        <div className='home-team'>
          {gameState.home.name}
          {globalState.playTeam === gameState.home.name &&
            <div className='player'>Player</div>}
        </div>
      </div>
    </StyledTeamScore>
  )
}

export default TeamScore;

const StyledTeamScore = styled.div`
  /* box-shadow: 0 0 0 1px black inset; */
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  background-color: black;

  .title {
    font-size: 30px;
    color: #FFFFFF;
    margin-bottom: 20px;
  }

  .score-board {
    display: flex;
    margin-top: 16px;
    line-height: 30px;
    font-size: 30px;
    font-weight: 800;
    color: #888888;

    .away-team, .home-team {
      font-size: 50px;
      color: #FFFFFF;

      .player {
        color: red;
        font-size: 16px;
        font-weight: 600;
        text-align: center;
        margin-top: 8px;
      }
    }

    .away-team {
      text-align: right;
    }

    .home-team {
      text-align: left;
    }

    .score {
      font-size: 50px;
      color: #FFFFFF;
      margin: 0 40px;
    }
  }
`;
