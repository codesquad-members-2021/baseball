import styled from 'styled-components';

const LogList = () => {
  return (
    <LogListDiv>
      <LogBox>
        <LogPitcher>7번타자 류현진</LogPitcher>
        <LogLine>
          <LogIdx>5</LogIdx>
          <LogName>스트라이크</LogName>
          <LogBoard>S1 B0</LogBoard>
        </LogLine>
        <LogLine>
          <LogIdx>5</LogIdx>
          <LogName>스트라이크</LogName>
          <LogBoard>S1 B0</LogBoard>
        </LogLine>
      </LogBox>
    </LogListDiv>
  );
};

const LogListDiv = styled.div`
  padding: 20px 20px;
  border: solid 4px white;
  border-top: none;
  border-right: none;
`;
const LogBox = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XXS};
`;
const LogPitcher = styled.div`
  margin: 10px 0;
  color: ${({ theme }) => theme.colors.green};
`;
const LogIdx = styled.div`
  padding: 2px 6px 0 6px;
  text-align: center;
  color: ${({ theme }) => theme.colors.black};
  background-color: ${({ theme }) => theme.colors.white};
  border-radius: 20px;
  font-size: ${({ theme }) => theme.fontSizes.TXS};
  font-weight: 700;
`;
const LogName = styled.div`
  width: 110px;
  margin-right: 30px;
  text-align: center;
  color: ${({ theme }) => theme.colors.white};
`;
const LogBoard = styled.div`
  color: ${({ theme }) => theme.colors.lightGray};
  font-weight: 00;
`;

const LogLine = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: 7px 0;
  color: ${({ theme }) => theme.colors.white};
`;
export default LogList;
