import styled from 'styled-components';
import { useState, useEffect, useContext } from 'react';
import { GlobalContext } from '../../App';
import { BoardHistoryContext } from '../provider/Context';

const LogList = () => {
  const { ballCnt } = useContext(BoardHistoryContext);
  const {
    logArr,
    setLogArr,
    myTeam,
    currHitter,
    setCurrHitter,
    currTeamLog,
    setCurrTeamLog,
    setTotalOutCount,
  } = useContext(GlobalContext);
  //Stadium에서 설정하면 한템포 빠를까 해 useContext로 올려버림
  // const [logArr, setLogArr] = useState([]);
  const [batOrder, setBatOrder] = useState(1);

  useEffect(() => {
    // setLogArr((logArr) => [...logArr, ballCnt]);
    if (ballCnt.HitInfo === 'O') {
      // console.log('현재 타자!', currHitter.id, currHitter);
      console.log('🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥', ballCnt.HitInfo);
      setBatOrder((batOrder) => batOrder + 1);
      setCurrHitter({ ...currHitter, out: currHitter.out + 1 });
      setCurrHitter(myTeam[batOrder]);
      setCurrTeamLog([...currTeamLog, logArr]);
      setLogArr([]);
      // setTimeout(() => setLogArr([]), 3000);

      setTotalOutCount((totalOutCount) => totalOutCount + 1);
    }
    //이 데이터가 오지 않아 잡지를 못함 이경우를 잡지를 못함...제발....
    if (ballCnt.HitInfo === 'H') {
      console.log('🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥', ballCnt.HitInfo);

      setBatOrder((batOrder) => batOrder + 1);
      setCurrHitter({ ...currHitter, hit: currHitter.hit + 1 });
      //myTeam으로 가져올지 homeTeam으로 가져올지 모그렛음
      setCurrHitter(myTeam[batOrder]);
      setCurrTeamLog([...currTeamLog, logArr]);
      setLogArr([]);
      //3초 있다 지우면 H안타나 O한것도 지울 수 있을거라 생각
      // setTimeout(() => setLogArr([]), 3000);
    }
  }, [ballCnt]);

  const LogBoxes = () => {
    if (currTeamLog) {
      return currTeamLog.map((logBox, idx) => {
        var sCnt = 0;
        var bCnt = 0;
        return (
          <LogBoxDiv key={idx}>
            <LogHitter>
              {myTeam[idx].battingOrder}번타자 {myTeam[idx].name}
            </LogHitter>
            <>
              {logBox?.map((ele, i) => {
                if (
                  ele.HitInfo !== ' ' &&
                  (ele.HitInfo === 'S' || ele.HitInfo === 'B')
                ) {
                  return (
                    <LogLine key={i}>
                      <LogIdx>{i}</LogIdx>
                      <LogName>
                        {ele.HitInfo === 'S' ? '스트라이크' : '볼'}
                      </LogName>
                      <LogBoard>
                        S{ele.S} B{ele.B}
                      </LogBoard>
                    </LogLine>
                  );
                }
                // 데이터가 정확하게 오면 위처럼 map돌릴 필요가 없고 이렇게 돌리면 됨
                // if (ele.HitInfo === 'O') {
                //   return <LogLineMsg key={i}>⚾️ 아웃 ⚾️</LogLineMsg>;
                // }
                // if (ele.HitInfo === 'H') {
                //   return <LogLineMsg key={i}>🥎 안타 🥎</LogLineMsg>;
                // }
              })}
            </>
            <>
              {logBox?.map((ele, i) => {
                if (ele.HitInfo === 'S') {
                  sCnt += 1;
                  if (sCnt === 3) {
                    return <LogLineMsg key={i}>⚾️ 아웃 ⚾️</LogLineMsg>;
                  }
                } else if (ele.HitInfo === 'B') {
                  bCnt += 1;
                  if (bCnt === 4) {
                    return <LogLineMsg key={i}>🥎 안타 🥎</LogLineMsg>;
                  }
                } else return <></>;
              })}
            </>
          </LogBoxDiv>
        );
      });
    } else return <></>;
  };
  const LogBox = () => {
    if (logArr) {
      console.log('box를 뿌릴때 currTeamLog', currTeamLog);
      console.log('box- logArr', logArr);

      return (
        <LogBoxDiv>
          <LogHitter>
            {currHitter?.battingOrder}번타자 {currHitter?.name}
          </LogHitter>
          <>
            {logArr.map((ele, i) => {
              if (
                ele.HitInfo !== ' ' &&
                (ele.HitInfo === 'S' || ele.HitInfo === 'B')
              ) {
                return (
                  <LogLine key={i}>
                    <LogIdx>{i}</LogIdx>
                    <LogName>
                      {ele.HitInfo === 'S' ? '스트라이크' : '볼'}
                    </LogName>
                    <LogBoard>
                      S{ele.S} B{ele.B}
                    </LogBoard>
                  </LogLine>
                );
              }
              if (ele.HitInfo === 'O') {
                return <LogLineMsg key={i}>⚾️ 아웃 ⚾️</LogLineMsg>;
              }
              if (ele.HitInfo === 'H') {
                return <LogLineMsg key={i}>🥎 안타 🥎</LogLineMsg>;
              }
            })}
          </>
        </LogBoxDiv>
      );
    } else return <></>;
  };

  return (
    <LogListWrap>
      <LogListDiv>
        <LogBox />
        <LogBoxes />
      </LogListDiv>
    </LogListWrap>
  );
};
const LogBoxDiv = styled.div``;
const LogListWrap = styled.div`
  padding: 20px 20px;
  border: solid 4px white;
  border-top: none;
  border-right: none;
`;
const LogListDiv = styled.div`
  display: flex;
  flex-direction: column;
  height: 550px;
  font-size: ${({ theme }) => theme.fontSizes.XXS};
  overflow: auto;
`;
const LogHitter = styled.div`
  margin: 10px 0;
  font-size: ${({ theme }) => theme.fontSizes.XS};
  font-weight: 500;
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
