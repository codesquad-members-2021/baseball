import { useContext } from 'react';
import styled from 'styled-components';
import { GlobalContext } from '../../App';

const CurrentPlayer = () => {
  const { isHome, myTeam, counterTeam } = useContext(GlobalContext);
  const myPitcher = myTeam.filter((player) => player.pitcher === true)[0];
  const counterPitcher = counterTeam.filter(
    (player) => player.pitcher === true
  )[0];

  return (
    <CurrentPlayerDiv>
      <PlayerTag>PITCHER</PlayerTag>
      <Player>
        {isHome ? (
          <PlayerName>{myPitcher?.name}</PlayerName>
        ) : (
          <PlayerName>{counterPitcher?.name}</PlayerName>
        )}
        {isHome ? (
          <PitcherNum>#{myPitcher?.backNumber}</PitcherNum>
        ) : (
          <PitcherNum>#{counterPitcher?.backNumber}</PitcherNum>
        )}
      </Player>
      <PlayerTag>HITTER</PlayerTag>
      <Player>
        <PlayerName>캡틴아메</PlayerName>
        <PlayerRatio>1타석 0안타</PlayerRatio>
      </Player>
    </CurrentPlayerDiv>
  );
};

const CurrentPlayerDiv = styled.div`
  display: grid;
  align-items: center;
  padding: 20px 30px;
  border: solid 4px white;
  border-top: none;
  border-right: none;
`;
const Player = styled.div`
  padding: 8px 0;
  display: grid;
  grid-template-columns: 1fr 1fr;
  text-align: center;
`;
const PlayerName = styled.div`
  color: ${({ theme }) => theme.colors.gray};
  font-size: ${({ theme }) => theme.fontSizes.XXS};
`;
const PitcherNum = styled.div`
  color: ${({ theme }) => theme.colors.yellow};
  font-size: ${({ theme }) => theme.fontSizes.XS};
`;
const PlayerRatio = styled.div`
  color: ${({ theme }) => theme.colors.yellow};
  font-size: ${({ theme }) => theme.fontSizes.XS};
`;
const PlayerTag = styled.div`
  padding: 3px;
  border: dotted 2px white;
  border-radius: 0.5rem;
  text-align: center;
  color: white;
  font-size: ${({ theme }) => theme.fontSizes.XS};
`;

export default CurrentPlayer;
