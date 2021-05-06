import styled from 'styled-components';

const RecordOfPlayer = () => {
  return (
    <StyledRecordOfPlayer>
      <Result>안타!</Result>
      <Record>
        <Idx>5</Idx> <Type>스트라이크</Type>{' '}
        <Counter>
          <BallCnt>2</BallCnt>
          <StrikeCnt>3</StrikeCnt>
        </Counter>
      </Record>
      <Record>
        <Idx>4</Idx> <Type>볼</Type>{' '}
        <Counter>
          <BallCnt>1</BallCnt>
          <StrikeCnt>3</StrikeCnt>
        </Counter>
      </Record>
    </StyledRecordOfPlayer>
  );
};

export default RecordOfPlayer;
const StyledRecordOfPlayer = styled.div`
  width: 100%;
  display: flex;
  flex-direction: column;
`;
const Result = styled.div`
  color: #488b9b;
  margin-left: 4rem;
  padding: 0.3rem 0;
`;
const Record = styled.div`
  width: 100%;
  display: grid;
  grid-template-columns: 0.1fr 0.6fr 0.5fr;
  padding: 0.3rem 0;
`;
const Idx = styled.span`
  text-align: center;
  font-size: 16px;
  width: 1rem;
  color: black;
  background-color: white;
  border-radius: 25px;
`;
const Type = styled.span`
  justify-self: center;
  text-align: center;
  width: 6rem;
`;

const Counter = styled.span`
  text-align: center;
  color: gray;
`;
const BallCnt = styled.span`
  padding: 0 0.5rem;
  &::before {
    content: 'B';
  }
`;
const StrikeCnt = styled.span`
  &::before {
    content: 'S';
  }
`;
