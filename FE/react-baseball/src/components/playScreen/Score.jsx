import Title from '../startScreen/Title';
import styled from 'styled-components';
import { useContext } from 'react';
import { GlobalContext } from '../../App';

const Score = () => {
  const { isHome, myTeamName, counterTeamName } = useContext(GlobalContext);

  return (
    <ScoreDiv>
      <Title type='play' />
      <TeamDiv>
        <TeamSingleDiv>
          {/* <AwayTeam>{counterTeamName}</AwayTeam> */}
          {!isHome ? (
            <AwayTeam>{myTeamName}</AwayTeam>
          ) : (
            <AwayTeam>{counterTeamName}</AwayTeam>
          )}

          {!isHome && <TeamCurrent>Player</TeamCurrent>}
        </TeamSingleDiv>
        <TeamScore>1</TeamScore>
        <VSDiv>vs</VSDiv>
        <TeamScore>5</TeamScore>
        <TeamSingleDiv>
          {/* <HomeTeam>Marvel</HomeTeam> */}
          {isHome ? (
            <HomeTeam>{myTeamName}</HomeTeam>
          ) : (
            <HomeTeam>{counterTeamName}</HomeTeam>
          )}
          {isHome && <TeamCurrent>Player</TeamCurrent>}
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
  color: ${({ theme }) => theme.colors.white};
`;

const TeamDiv = styled.div`
  display: flex;
  font-size: ${({ theme }) => theme.fontSizes.XXL};
  font-weight: 800;
`;

const TeamSingleDiv = styled.div`
  text-align: center;
`;
const AwayTeam = styled.div``;

const HomeTeam = styled.div``;

const TeamScore = styled.div`
  margin: 0 30px;
`;

const TeamCurrent = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XS};
  color: ${({ theme }) => theme.colors.orange};
`;

const VSDiv = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.L};
  color: ${({ theme }) => theme.colors.lightGray};
`;

export default Score;
