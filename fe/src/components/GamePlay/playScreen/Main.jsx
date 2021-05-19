import styled from 'styled-components';
import History from 'components/GamePlay/playScreen/History';
import Screen from 'components/GamePlay/playScreen/Screen';

const Main = () => {
  return (
    <StyldeMain>
      <Screen />
      <History />
    </StyldeMain>
  );
};

export default Main;

const StyldeMain = styled.main`
  display: flex;
  width: 100%;
  height: 80%;
  border-top: 0.6rem solid #b4b4b4;
`;
