import { useContext } from 'react';
import styled from 'styled-components';
import { ScoreNBaseContext } from '../GamePlay';

const Score = ({ teamName, selectTeam }) => {
  const { score } = useContext(ScoreNBaseContext);
  const TITLE = 'BASEBALL GAME ONLINE';
  const TURN = 'Player';
  const homeScore = score.home.reduce((acc, cur) => acc + cur, 0);
  const awayScore = score.away.reduce((acc, cur) => acc + cur, 0);

  return (
    <StyledScore>
      <div className='title'>{TITLE}</div>
      <div className='teams'>
        <div className='home'>
          <div className='teams-name'>
            {teamName.home}
            {teamName.home == selectTeam && <div className='turn'>{TURN}</div>}
          </div>

          <div className='teams-score'>{homeScore}</div>
        </div>
        <div className='teams-vs'>vs</div>
        <div className='away'>
          <div className='teams-score'>{awayScore}</div>
          <div className='teams-name'>
            {teamName.away}
            {teamName.away == selectTeam && <div className='turn'>{TURN}</div>}
          </div>
        </div>
      </div>
    </StyledScore>
  );
};

const StyledScore = styled.div`
  .title {
    font-size: 2.5rem;
    font-weight: 600;
    color: #fff;
    text-align: center;
  }
  .teams {
    display: grid;
    grid-template-columns: 1fr 6rem 1fr;
    text-align: center;
    align-items: flex-end;
    padding: 1rem 0;
    color: #f6f0f0;
    font-weight: 600;
    .home,
    .away {
      display: flex;
      align-items: center;
      font-size: 3rem;
    }
    .teams-vs {
      font-size: 4rem;
      color: #777;
    }
    .teams-name {
      font-size: 3rem;
      position: relative;
    }
    .turn {
      position: absolute;
      padding-top: 0.5rem;
      font-size: 1.5rem;
      left: 40%;
      color: #ff4545;
    }
  }
  .home {
    justify-content: flex-end;
    .teams-score {
      margin: 0 3rem;
    }
  }
  .away {
    justify-content: flex-start;
    .teams-score {
      margin: 0 3rem;
    }
  }
`;

export default Score;
