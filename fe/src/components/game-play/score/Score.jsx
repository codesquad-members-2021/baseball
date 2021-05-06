import styled from 'styled-components';

const Score = ({ teamName, score, turn }) => {
  const TITLE = 'BASEBALL GAME ONLINE';
  const TURN = 'Player';
  return (
    <StyleScore>
      <div className='title'>{TITLE}</div>
      <div className='teams'>
        <div className='home'>
          <div className='teams-name'>
            {teamName.home}
            {turn && <div className='turn'>{TURN}</div>}
          </div>

          <div className='teams-score'>{score.home}</div>
        </div>
        <div className='teams-vs'>vs</div>
        <div className='away'>
          <div className='teams-score'>{score.away}</div>
          <div className='teams-name'>
            {teamName.away}
            {!turn && <div className='turn'>{TURN}</div>}
          </div>
        </div>
      </div>
    </StyleScore>
  );
};

const StyleScore = styled.div`
  .title {
    font-size: 3rem;
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
      justify-content: center;
      align-items: center;
      font-size: 5rem;
    }
    .teams-vs {
      font-size: 4rem;
      color: #777;
    }
    .teams-name {
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
    .teams-score {
      margin-left: 3rem;
    }
  }
  .away {
    .teams-score {
      margin-right: 3rem;
    }
  }
`;

export default Score;
