import styled from "styled-components";

const Top = ({ currentHitter, currentPitcher }) => {
  const { name: pitcherName, pitchCount } = currentPitcher;
  const { name: hitterName, plateAppearanceCount, hitCount } = currentHitter;
  return (
    <StyledTop>
      <Atk>
        <Role>투수</Role>
        <Player>
          <PlayerName>{pitcherName}</PlayerName>
          <PitcherInfo>{pitchCount}</PitcherInfo>
        </Player>
      </Atk>
      <Def>
        <Role>타자</Role>
        <Player>
          <PlayerName>{hitterName}</PlayerName>
          <BatterInfo>
            {plateAppearanceCount}타석 {hitCount}안타
          </BatterInfo>
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
    content: "#";
  }
`;

const BatterInfo = styled.span`
  color: #488b9b;
  margin-left: 0.5rem;
`;
