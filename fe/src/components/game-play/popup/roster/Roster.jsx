import styled from 'styled-components';
import TeamRoster from './TeamRoster';
const Roster = ({ memberList, teamName, selectTeam }) => {
  return (
    <StyledRoster>
      <TeamRoster memberList={memberList.home} teamName={teamName.home} selectTeam={selectTeam}/>
      <TeamRoster memberList={memberList.away} teamName={teamName.away} selectTeam={selectTeam}/>
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
