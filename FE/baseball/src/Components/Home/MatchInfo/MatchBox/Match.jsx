import styled from 'styled-components';
import TeamName from './TeamName';
import VS from './VS';

const Match = () => {
  return (
    <MatchStyle>
      <TeamName />
      <VS />
      <TeamName />
    </MatchStyle>
  );
};

export default Match;

const MatchStyle = styled.div`
  display: flex;
  width: 100%;
  padding: 10px;
  justify-content: space-evenly;
`;
