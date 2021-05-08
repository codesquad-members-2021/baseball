import styled from 'styled-components';

const Top = () => {
  return (
    <StyledTop>
      <Atk>
        <Role>투수</Role>
        <Player>
          <PlayerName>최동원</PlayerName>
          <PitcherInfo>39</PitcherInfo>
        </Player>
      </Atk>
      <Def>
        <Role>타자</Role>
        <Player>
          <PlayerName>류현진</PlayerName>
          <BatterInfo>1타석 0안타</BatterInfo>
        </Player>
      </Def>
    </StyledTop>
  );
};

export default Top;

const StyledTop = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  height: 180px;
  padding: 0 2rem;
  border-bottom: 3px solid gray;
`;

const Atk = styled.div``;

const Def = styled.div``;

const Role = styled.div`
  font-size: 30px;
`;

const Player = styled.div`
  font-size: 30px;
`;

const PlayerName = styled.span`
  color: #a9d1da;
`;

const PitcherInfo = styled.span`
  color: #488b9b;
  margin-left: 0.5rem;
  &::before {
    content: '#';
  }
`;

const BatterInfo = styled.span`
  color: #488b9b;
  margin-left: 0.5rem;
`;
