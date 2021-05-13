import styled from 'styled-components';
import Span from 'components/common/Span';
import Pitcher from 'components/GamePlay/playHeader/Pitcher';
import Hitter from 'components/GamePlay/playHeader/Hitter';

const HeaderNotice = ({ type }) => {
  return (
    <NoticeWrap>
      <Position>{type === 'pitcher' ? '투수' : '타자'}</Position>
      <Notice>
        {type === 'pitcher' ? <Pitcher type={type} /> : <Hitter type={type} />}
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
