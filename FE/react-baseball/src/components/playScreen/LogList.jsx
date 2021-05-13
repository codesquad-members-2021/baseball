import styled from 'styled-components';
import { useState, useEffect, useContext } from 'react';
import { GlobalContext } from '../../App';
import { BoardHistoryContext } from '../provider/Context';

const LogList = () => {
  const { ballCnt } = useContext(BoardHistoryContext);
  const {
    homeTeam,
    myTeam,
    currHitter,
    setCurrHitter,
    totalOutCount,
    setTotalOutCount,
  } = useContext(GlobalContext);
  const [logArr, setLogArr] = useState([]);
  const [batOrder, setBatOrder] = useState(1);
  console.log('⭐️', myTeam);

  useEffect(() => {
    setLogArr((logArr) => [...logArr, ballCnt]);
    if (ballCnt.HitInfo === 'O') {
      // console.log('현재 타자!', currHitter.id, currHitter);
      console.log('토탈!', totalOutCount);
      setTotalOutCount((totalOutCount) => totalOutCount + 1);
      console.log('이제 하나씩 올렷다', totalOutCount);
    }
    if (ballCnt.HitInfo === 'H') {
      //한박자 느린 Hitter 변경
      //아웃과 안타시 타자 변경
      console.log('🔥현재나의타자정보번호', currHitter, 'BBBb', batOrder);
      setCurrHitter({ ...currHitter, hit: currHitter.hit + 1 });
      setBatOrder((batOrder) => batOrder + 1);
      console.log('batOrder 바뀌지않앗겟지', batOrder);
      //myTeam으로 가져올지 homeTeam으로 가져올지 모그렛음
      setCurrHitter(myTeam[batOrder]);
      console.log('⭐️현재나의타자정보번호', currHitter, 'BBB', batOrder);
    }
  }, [ballCnt]);

  const LogCards = () => {
    console.log('============================', logArr);
    return logArr.map((ele, i) => {
      // console.log('logarr 하ㅏ나식', ele);
      if (ele.HitInfo !== ' ' && (ele.HitInfo === 'S' || ele.HitInfo === 'B')) {
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
        // setTotalOutCount((prevCnt) => prevCnt + 1);
        // console.log('토탈아웃', totalOutCount);
        return <LogLineMsg key={i}>⚾️ 아웃 ⚾️</LogLineMsg>;
      }
      if (ele.HitInfo === 'H') {
        // console.log(myTeam);
        return <LogLineMsg key={i}>🥎 안타 🥎</LogLineMsg>;
      }
    });
  };

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
  width: 52px;
  text-align: center;
  color: ${({ theme }) => theme.colors.lightGray};
  font-weight: 500;
`;
const LogLine = styled.div`
  display: flex;
  flex-direction: row;
  align-items: center;
  margin: 7px 0;
  color: ${({ theme }) => theme.colors.white};
`;

const LogLineMsg = styled.div`
  padding: 0 0 0 40px;
  color: ${({ theme }) => theme.colors.gray};
`;

export default LogList;
