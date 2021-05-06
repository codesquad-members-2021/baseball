import styled from 'styled-components';
import Top from './Top';
import Bottom from './Bottom';

const Record = () => {
  return (
    <StyledRecord>
      <Top></Top>
      <Bottom></Bottom>
    </StyledRecord>
  );
};

export default Record;

const StyledRecord = styled.div`
  position: absolute;
  width: 320px;
  height: 720px;
  left: 960px;
  top: 0px;
`;
