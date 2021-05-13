import { useContext, useEffect } from 'react';
import styled from 'styled-components';
import { GlobalContext } from '../../App';

const PlayInning = (props) => {
  const {
    currInning,
    setCurrInning,
    totalOutCount,
    setTotalOutCount,
    inningTop,
    setInningTop,
    isDefense,
    setIsDefense,
  } = useContext(GlobalContext);

  if (totalOutCount === 0) {
    setInningTop(true);
  }

  if (totalOutCount >= 3) {
    if (totalOutCount === 3) {
      setInningTop(false);
      // 공격, 수비를 바꿔주는 로직 추가하기
    }
    if (totalOutCount === 6) {
      setCurrInning(currInning + 1);
      setTotalOutCount(0);
    }
  }
  return (
    <PlayInningDiv>
      <Span>
        {currInning}회{inningTop ? '초' : '말'} {isDefense ? '수비' : '공격'}
      </Span>
    </PlayInningDiv>
  );
};

const PlayInningDiv = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  margin: 20px;
  padding: 5px 12px;
  border: dotted 2px white;
  border-radius: 0.5rem;
  height: fit-content;
`;

const Span = styled.span`
  color: ${({ theme }) => theme.colors.white};
  font-size: ${({ theme }) => theme.fontSizes.S};
  font-weight: 700;
`;

export default PlayInning;
