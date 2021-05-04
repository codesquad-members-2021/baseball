import styled from 'styled-components';
import MatchInfoBody from './MatchInfoBody';
import MatchInfoTitle from './MatchInfoTitle';

const MatchInfo = () => {
  return (
    <MatchInfoStyle>
      <MatchInfoTitle />
      <MatchInfoBody />
    </MatchInfoStyle>
  );
};

export default MatchInfo;

const MatchInfoStyle = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 500px;
`;
