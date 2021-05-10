import styled from 'styled-components';
import RosterPlayer from './RosterPlayer';

const TeamRoster = ({ member_list, player_name, team_name = '베리베리 스트로베리', player = false }) => {
  const HEADS = ['타자', '타석', '안타', '아웃', '평균'];
  const TOTALTEXT = 'Totals';
  const heads = HEADS.map((head, idx) => <div key={idx}>{head}</div>);
  let [totalAtBat, totalSafety, totalOut] = [0, 0, 0];
  
  const members = member_list.map((member, idx) => {
    const { at_bat, safety, out } = member;
    totalAtBat += at_bat;
    totalSafety += safety;
    totalOut += out;
    return <RosterPlayer {...member} player_name={player_name} key={idx} />
  });

  return (
    <StyledTeamRoster>
      <div className='title'>{team_name} {player && <div className='player'>Player</div>}</div>
      <ul className='roster'>
        <li className='roster--head'>
          {heads}
        </li>
        {members}
        <li className='roster--total'>
          <div>{TOTALTEXT}</div>
          <div>{totalAtBat}</div>
          <div>{totalSafety}</div>
          <div>{totalOut}</div>
          <div></div>
        </li>
      </ul>
    </StyledTeamRoster>
  );
}

const StyledTeamRoster = styled.div`
  .title {
    font-size: 1.5rem;
    font-weight: 600;
    color: #fff;
    border-bottom: 3px solid #fff;
    text-align: center;
    padding-top: 0.5rem;
    padding-bottom: 1rem;
    .player {
      display: inline-block;
      color: #ff4545;
      font-size: 0.75rem;
      font-weight: 600;
      position: relative;
      top: -0.25rem;
    }
  }
  ul {
    padding: 0;
    margin: 0;
  }
  .roster {
    li {
      display: grid;
      grid-template-columns: 2fr 1fr 1fr 1fr 1.5fr;
      color: #d2d2d2;
      font-size: 1.25rem;
      text-align: center;
      padding: 0.625rem;
      &:not(:last-child) {
        border-bottom: 1px solid #555;
      }
    }
    li.roster--head {
      border-bottom: 2px solid #777;
      color: #aaa;
    }
    li.roster--total {
      color: #fff;
      font-weight: 600;
    }
    li.roster--member {
    }
    .roster--member.active {
      color: #ff4545;
    }
  }
`;

export default TeamRoster;