import styled from 'styled-components';

const Stadium = () => {
  return (
    <StadiumDiv>
      <PlayDiv>
        <PlayBoardDiv>
          <PlayBoard>
            <BoardTag>S</BoardTag>
            <BoardNum>🟡 🟡 </BoardNum>
          </PlayBoard>
          <PlayBoard>
            <BoardTag>B</BoardTag>
            <BoardNum>⚾️</BoardNum>
          </PlayBoard>
          <PlayBoard>
            <BoardTag>O</BoardTag>
            <BoardNum>🔴 🔴</BoardNum>
          </PlayBoard>
        </PlayBoardDiv>
        <PlayInning>2회초 수비</PlayInning>
      </PlayDiv>
      <PlayerDiv>
        <Player />
      </PlayerDiv>
      <PlayButton>PITCH</PlayButton>
    </StadiumDiv>
  );
};

const StadiumDiv = styled.div`
  box-sizing: border-box;
  opacity: 80%;
  background-image: url('./baseballRound.jpg');
  background-position: center;
`;
const PlayDiv = styled.div`
  display: flex;
  justify-content: space-between;
`;
const PlayBoardDiv = styled.div`
  margin: 20px 25px;
`;
const PlayBoard = styled.div`
  display: flex;
  align-items: center;
`;
const BoardTag = styled.div`
  margin-right: 20px;
  color: white;
  font-size: ${({ theme }) => theme.fontSizes.L};
  font-weight: 600;
`;
const BoardNum = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.S};
`;

const PlayInning = styled.div`
  margin: 20px;
  padding: 5px 12px;
  border: dotted 2px white;
  border-radius: 0.5rem;
  text-align: center;
  color: white;
  font-size: ${({ theme }) => theme.fontSizes.S};
  font-weight: 800;
`;
const PlayerDiv = styled.div`
  position: absolute;
`;
const Player = styled.div`
  position: relative;
`;
const PlayButton = styled.button`
  position: relative;
  left: 465px;
  top: 130px;
  /* display: flex;
  justify-content: center;
  align-items: center; */
  padding: 10px 40px;
  text-align: center;
  background-color: black;
  color: white;
  border: dotted 2px white;
  border-radius: 0.5rem;
  font-size: ${({ theme }) => theme.fontSizes.XS};
  opacity: 80%;
  cursor: pointer;
  &:hover {
    opacity: none;
    background-color: white;
    color: black;
  }
`;

export default Stadium;
