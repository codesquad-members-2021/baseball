import { useState } from 'react';
import styled from 'styled-components';
import Span from 'components/common/Span';
import Pitcher from 'components/GamePlay/playHeader/Pitcher';
import Hitter from 'components/GamePlay/playHeader/Hitter';

const HeaderNotice = ({ type }) => {
  // UI 작업을 위한 TEST 용
  // 실제로는 상위에서 받은데이터를 내려줘서 업데이트
  // reducer 사용??
  const [count, setCount] = useState({
    pitcher: {
      count: 39,
    },
    hitter: {
      turn: 1,
      hit: 2,
    },
  });

  const { pitcher, hitter } = count;

  // 임시

  return (
    <NoticeWrap>
      <Position>{type === 'pitcher' ? '투수' : '타자'}</Position>
      <Notice>
        {type === 'pitcher' ? (
          <Pitcher pitcher={pitcher} />
        ) : (
          <Hitter hitter={hitter} />
        )}
      </Notice>
    </NoticeWrap>
  );
};

export default HeaderNotice;

const NoticeWrap = styled.div`
  padding-right: 2rem;
  display: flex;
  flex-direction: column;
`;

const Position = styled(Span)`
  margin: 0;
  padding: 0;
  font-size: ${({ theme }) => `${theme.fontSizes.SMALL}rem`};
  color: ${({ theme }) => theme.colors.white};
`;

const Notice = styled.div`
  margin: 0;
  padding: 0;
  span {
    font-size: ${({ theme }) => `${theme.fontSizes.SMALL}rem`};
    color: ${({ theme }) => theme.colors.lightBlue};
    & + span {
      padding-left: 1rem;
      color: ${({ theme }) => theme.colors.darkBlue};
    }
  }
`;
