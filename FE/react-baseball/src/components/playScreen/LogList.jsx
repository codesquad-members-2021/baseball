import styled from 'styled-components';
import { useState, useEffect, useContext } from 'react';
import { boardHistory, BoardHistoryContext } from '../provider/Context';
import { GlobalContext } from '../../App';
const LogList = () => {
  const { ballCnt } = useContext(BoardHistoryContext);
  const [logArr, setLogArr] = useState([]);
  const { totalOutCount, setTotalOutCount } = useContext(GlobalContext);

  useEffect(() => {
    setLogArr((logArr) => [...logArr, ballCnt]);
  }, [ballCnt]);

  const LogCards = () => {
    return logArr.map((ele, i) => {
      // if (ele.O !== 0) {
      //   var prevTotalCnt = totalOutCount;
      //   setTotalOutCount((totalOutCount) => totalOutCount + 1);
      //   return <LogLine key={i}>아웃입니다</LogLine>;
      // }
      if (ele.HitInfo !== ' ' && (ele.HitInfo === 'S' || ele.HitInfo === 'B')) {
        // if (ele.H === 1) return <LogLine key={i}>안타입니다</LogLine>;
        // if (ele.O === 1) return <LogLine key={i}>아웃입니다</LogLine>;
        return (
          <LogLine key={i}>
            <LogIdx>{i}</LogIdx>
            <LogName>{ele.HitInfo === 'S' ? '스트라이크' : '볼'}</LogName>
            <LogBoard>
              S{ele.S} B{ele.B}
            </LogBoard>
          </LogLine>
        );
      }

      if (ele.HitInfo === 'O') {
        return <LogLine key={i}>아웃입니다</LogLine>;
      }
      if (ele.HitInfo === 'H') {
        return <LogLine key={i}>안타입니다</LogLine>;
      }
      // if (ele.H === 1) {
      //   return <LogLine>안타입니다</LogLine>;
      // }
      // if (ele.O === 1) {
      //   return <LogLine>아웃입니다</LogLine>;
      // } else return null;
    });
  };
  // const setLogLine = () => {};
  // Pitch 누르면 -> dispatch 내용을 리스트에 넣기  -> useEffect로 내용바뀔때마가 map렌더링
  // 데이터 바로 받아서 리스트에 넣기

  return (
    <LogListDiv>
      <LogBox>
        <LogHitter>7번타자 류현진</LogHitter>
        <LogCards />
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
  display: flex;
  flex-direction: column;
  height: 550px;
  font-size: ${({ theme }) => theme.fontSizes.XXS};
  overflow: auto;
`;
const LogHitter = styled.div`
  margin: 10px 0;
  color: ${({ theme }) => theme.colors.green};
`;
const LogIdx = styled.div`
  width: 18px;
  height: 18px;
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
