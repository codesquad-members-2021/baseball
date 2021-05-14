import styled from 'styled-components';

const Player = ({ memberList, turn, pitchers }) => {
  const HOME = 'home';
  const AWAY = 'away';
  const getPlayer = () => {
    if (!memberList || !memberList[HOME] || !memberList[AWAY]) return;
    const result = {};
    const batterTeam = turn ? HOME : AWAY;
    const pitcherTeam = turn ? AWAY : HOME;
    for (const member of memberList[batterTeam]) {
      if (member.status) result.batter = member;
    }
    for (const member of memberList[pitcherTeam]) {
      if (member.id === pitchers[pitcherTeam]) result.pitcher = member;
    }
    return result;
  };
  const player = getPlayer();
  return (
    <StyledPlayer>
      <div className='player'>
        <div className='player-type'>투수</div>
        <div className='player-detail'>
          <div className='name'>{player?.pitcher.name}</div>
          <div className='detail'>#{player?.pitcher.id}</div>
        </div>
      </div>
      <div className='player'>
        <div className='player-type'>타자</div>
        <div className='player-detail'>
          <div className='name'>{player?.batter.name}</div>
          <div className='detail'>
            {player?.batter.atBat || 0}타석 {player?.batter.plate_appearance || 0}안타
          </div>
        </div>
      </div>
    </StyledPlayer>
  );
};

const StyledPlayer = styled.div`
  height: 100%;
  padding-bottom: 1.5rem;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  font-weight: 600;
  .player-type {
    color: #f6f0f0;
    font-size: 2rem;
    margin-bottom: 0.5rem;
  }
  .player-detail {
    display: flex;
    font-size: 1.5rem;
    .name {
      color: #cff0f7;
      margin-right: 0.5rem;
    }
    .detail {
      color: #79b5ce;
    }
  }
`;

export default Player;
