import { useContext } from 'react';
import styled from 'styled-components';
import { GlobalContext } from '../../App';

const PlayInning = (props) => {
  const {
    currInning,
    setCurrInning,
    totalOutCount,
    setTotalOutCount,
    isTop,
    toggleIsTop,
    isDefense,
    setIsDefense,
  } = useContext(GlobalContext);

  // if (!totalOutCount % 3) {
  //   // 초, 말 바꿔주기
  //   toggleIsTop();
  //   // setIsDefense(); 이것도 토글해야하는데... 모르겠다.
  //   if (totalOutCount === 6) {
  //     setCurrInning(currInning + 1);
  //     setTotalOutCount(0);
  //   }
  // }

  return (
    <PlayInningDiv>
      <Span>
        {currInning}회{isTop ? '초' : '말'} {isDefense ? '수비' : '공격'}
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
