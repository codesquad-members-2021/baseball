import styled from 'styled-components';

const Player = ({ memberList, turn, pitchers }) => {
  const HOME = 'home';
  const AWAY = 'away';

  const getMember = (id, members) => {
    for (const member of members) {
      if (member.id === id) return member;
    }
    return null;
  };

  const getBatter = (members) => {
    for (const member of members) {
      if (member.state) return member;
    }
    return null;
  };

  const pitcher = turn
    ? getMember(pitchers[HOME], memberList[HOME])
    : getMember(pitchers[AWAY], memberList[AWAY]);

  const batter = turn ? getBatter(memberList[HOME]) : getBatter(memberList[AWAY]);

  return (
    <StylePlayer>
      <div className='player'>
        <div className='player-type'>투수</div>
        <div className='player-detail'>
          <div className='name'>{pitcher.name}</div>
          <div className='detail'>#{pitcher.id}</div>
        </div>
      </div>
      <div className='player'>
        <div className='player-type'>타자</div>
        <div className='player-detail'>
          <div className='name'>{batter.name}</div>
          <div className='detail'>
            {batter.at_bat}타석 {batter.safety}안타
          </div>
        </div>
      </div>
    </StylePlayer>
  );
};

const StylePlayer = styled.div`
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
