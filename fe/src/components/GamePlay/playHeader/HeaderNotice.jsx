import styled from 'styled-components';

import Span from 'components/common/Span';
import Pitcher from 'components/GamePlay/playHeader/Pitcher';
import Hitter from 'components/GamePlay/playHeader/Hitter';

const HeaderNotice = ({ type }) => {
  const pitcher = type === 'pitcher';

  return (
    <NoticeWrap>
      <Position>{pitcher ? '투수' : '타자'}</Position>
      <Notice>{pitcher ? <Pitcher /> : <Hitter />}</Notice>
    </NoticeWrap>
  );
};

export default HeaderNotice;

const NoticeWrap = styled.div`
  min-width: 9rem;
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
