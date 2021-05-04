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
  align-items: center;
  width: 100%;
  height: 100%;
  padding: 0px 5px 5px 5px;
  justify-content: space-evenly;
`;
