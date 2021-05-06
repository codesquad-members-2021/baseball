import styled from 'styled-components';
import RecordOfPlayer from './RecordOfPlayer';

const Bottom = () => {
  return (
    <StyledBottom>
      <RecordWrapper>
        <Player>
          <PlayerInfo>
            <PlayerNum>7</PlayerNum> <PlayerName>류현진</PlayerName>
          </PlayerInfo>
          <RecordOfPlayer />
        </Player>
        <Player>
          <PlayerInfo>
            <PlayerNum>6</PlayerNum> <PlayerName>선동렬</PlayerName>
          </PlayerInfo>
          <RecordOfPlayer />
        </Player>
        <Player>
          <PlayerInfo>
            <PlayerNum>5</PlayerNum> <PlayerName>김광현</PlayerName>
          </PlayerInfo>
          <RecordOfPlayer />
        </Player>
        <Player>
          <PlayerInfo>
            <PlayerNum>5</PlayerNum> <PlayerName>김광현</PlayerName>
          </PlayerInfo>
          <RecordOfPlayer />
        </Player>
        <Player>
          <PlayerInfo>
            <PlayerNum>5</PlayerNum> <PlayerName>김광현</PlayerName>
          </PlayerInfo>
          <RecordOfPlayer />
        </Player>
        <Player>
          <PlayerInfo>
            <PlayerNum>5</PlayerNum> <PlayerName>김광현</PlayerName>
          </PlayerInfo>
          <RecordOfPlayer />
        </Player>
      </RecordWrapper>
    </StyledBottom>
  );
};

export default Bottom;

const StyledBottom = styled.div`
  font-size: 20px;
  display: flex;
  justify-content: center;
  width: 320px;
  height: 540px;
  background-color: black;
`;

const RecordWrapper = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100%;
  overflow-y: scroll;
  ::-webkit-scrollbar {
    display: none;
  }
`;
const Player = styled.div`
  display: flex;
  width: 100%;
  margin-left: 2.5rem;
  padding: 1.5rem 2rem;
  flex-direction: column;
`;
const PlayerInfo = styled.div`
  color: #a9d1da; // Player 중 가장 앞에 있을 때만 red로 바꿔야합니다.
  padding: 0.3rem 0;
`;
const PlayerNum = styled.span`
  &::after {
    content: '번 타자';
  }
`;
const PlayerName = styled.span``;
