import styled from 'styled-components';
import TeamRoster from './TeamRoster';
const Roster = ({ memberList }) => {
  // team_name 필요
  return (
    <StyledRoster>
      <TeamRoster memberList={memberList.home}/>
      <TeamRoster memberList={memberList.away} player={true}/>
    </StyledRoster>
  );
}

// 90vw는 돼야하는데 그러면 이상함...;
const StyledRoster = styled.div`
  margin: 0 auto;
  max-width: 60vw;
  margin-top: 5rem;
  border: 3px solid #fff;
  padding: 0.5rem 1rem;
  display: grid;
  grid-template-columns: 1fr 1fr;
  & > *:first-child {
    border-right: 1.5px solid #fff;
  }
  & > *:last-child {
    border-left: 1.5px solid #fff;
  }
`;

export default Roster;
