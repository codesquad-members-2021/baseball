import styled from 'styled-components';
import History from 'components/GamePlay/playScreen/History';

const Main = () => {
  return (
    <StyldeMain>
      <History />
    </StyldeMain>
  );
};

export default Main;

const StyldeMain = styled.main`
  display: flex;
  width: 100%;
  height: 80%;
`;
