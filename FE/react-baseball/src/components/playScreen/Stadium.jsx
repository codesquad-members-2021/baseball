import { useContext } from 'react';
import styled from 'styled-components';
import { boardHistory, BoardHistoryContext } from '../provider/ContextB';
import PlayInning from './PlayInning';

const Stadium = () => {
  const { ballCnt, dispatch } = useContext(BoardHistoryContext);
  // const boardHistoryLst = [boardHistory[S],boardHistory[B],boardHistory[O]]

  const PlayBoardTemp = ({ type }) => {
    if (type === 'S') {
      const arr = new Array(ballCnt.S).fill('🟡'); //[[0,0,0]]
      return <>{arr}</>; //{🟡🟡🟡}
    } else if (type === 'B') {
      const arr = new Array(ballCnt.B).fill('🟢');
      return <>{arr}</>;
    } else if (type === 'O') {
      const arr = new Array(ballCnt.O).fill('🔴');
      return <>{arr}</>;
    }
  };

  return (
    <StadiumDiv>
      <PlayDiv>
        <PlayBoardDiv>
          <PlayBoard>
            <BoardTag>S</BoardTag>
            <BoardNum>
              <PlayBoardTemp type='S' />
            </BoardNum>
          </PlayBoard>
          <PlayBoard>
            <BoardTag>B</BoardTag>
            <BoardNum>
              <PlayBoardTemp type='B' />
            </BoardNum>
          </PlayBoard>
          <PlayBoard>
            <BoardTag>O</BoardTag>
            <BoardNum>
              <PlayBoardTemp type='O' />
            </BoardNum>
          </PlayBoard>
        </PlayBoardDiv>
        <PlayInning />
      </PlayDiv>
      <PlayerDiv>
        <Player />
      </PlayerDiv>
      <PlayButton onClick={() => playPitch(ballCnt, dispatch)}>
        PITCH
      </PlayButton>
    </StadiumDiv>
  );
};

const playPitch = (ballCnt, dispatch) => {
  const tempBoardLst = ['S', 'B'];
  const randomBoard =
    tempBoardLst[Math.floor(Math.random() * tempBoardLst.length)];
  dispatch({ type: randomBoard });

  // boardHistory[randomBoard] += 1;

  // boardHistory[] += 1;
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
