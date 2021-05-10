import Title from '../Title';
import styled from 'styled-components';

const Score = () => {
  return (
    <ScoreDiv>
      <Title type='play' />
      <TeamDiv>
        <TeamSingleDiv>
          <Team>Captain</Team>
        </TeamSingleDiv>
        <TeamScore>1</TeamScore>
        <VSDiv>vs</VSDiv>
        <TeamScore>5</TeamScore>
        <TeamSingleDiv>
          <Team>Marvel</Team>
          <TeamCurrent>Player</TeamCurrent>
        </TeamSingleDiv>
      </TeamDiv>
    </ScoreDiv>
  );
};

const ScoreDiv = styled.div`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border-bottom: solid 4px white;
  color: white;
`;
const TeamDiv = styled.div`
  display: flex;
  font-size: ${({ theme }) => theme.fontSizes.XXL};
  font-weight: 800;
`;
const TeamSingleDiv = styled.div`
  text-align: center;
`;
const Team = styled.div``;
const TeamScore = styled.div`
  margin: 0 30px;
`;
const TeamCurrent = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XS};
  color: #ffaa00;
`;
const VSDiv = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.L};
  color: #b5b4b3;
`;

export default Score;
