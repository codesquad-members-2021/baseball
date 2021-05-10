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
            <BoardNum>🟢</BoardNum>
          </PlayBoard>
          <PlayBoard>
            <BoardTag>O</BoardTag>
            <BoardNum>🔴 🔴</BoardNum>
          </PlayBoard>
        </PlayBoardDiv>
        <PlayInningDiv>
          <PlayInning>2회초 수비</PlayInning>
        </PlayInningDiv>
      </PlayDiv>
      <PlayerDiv>
        <Player />
      </PlayerDiv>
      <PlayButton onClick={() => playPitch()}>PITCH</PlayButton>
    </StadiumDiv>
  );
};
var tempBoardLst = ['S', 'B', 'O'];

const playPitch = () => {
  console.log(tempBoardLst[Math.floor(Math.random() * tempBoardLst.length)]);
};
const StadiumDiv = styled.div`
  box-sizing: border-box;
  opacity: 90%;
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
  font-size: ${({ theme }) => theme.fontSizes.M};
  font-weight: 600;
`;
const BoardNum = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.S};
`;
const PlayInningDiv = styled.div``;
const PlayInning = styled.div`
  margin: 20px;
  padding: 5px 12px;
  border: dotted 2px white;
  border-radius: 0.5rem;
  color: ${({ theme }) => theme.colors.white};
  font-size: ${({ theme }) => theme.fontSizes.S};
  font-weight: 700;
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
  padding: 10px 40px;
  text-align: center;
  background-color: black;
  color: ${({ theme }) => theme.colors.white};
  border: dotted 2px white;
  border-radius: 0.5rem;
  font-size: ${({ theme }) => theme.fontSizes.XS};
  opacity: 80%;
  cursor: pointer;
  &:hover {
    opacity: none;
    background-color: ${({ theme }) => theme.colors.white};
    color: ${({ theme }) => theme.colors.black};
  }
`;

export default Stadium;
