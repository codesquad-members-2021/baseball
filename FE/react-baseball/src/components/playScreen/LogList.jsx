import styled from 'styled-components';

const LogList = () => {
  return (
    <LogListDiv>
      Log
      <div></div>
      <LogPitcher>7번타자 류현진</LogPitcher>
      <LogLine>스트라이크</LogLine>
    </LogListDiv>
  );
};

const LogListDiv = styled.div`
  text-align: center;
  border: solid 4px white;
  border-top: none;
  border-right: none;
`;
const LogPitcher = styled.div`
  color: white;
  font-size: ${({ theme }) => theme.fontSizes.XXS};
`;
const LogLine = styled.div`
  color: white;
  font-size: ${({ theme }) => theme.fontSizes.XXS};
`;
export default LogList;
