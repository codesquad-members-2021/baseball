import styled from 'styled-components';

import HeaderLeft from 'components/GamePlay/playHeader/HeaderLeft';
import HeaderRight from 'components/GamePlay/playHeader/HeaderRight';

const Header = () => {
  return (
    <GamePlayHeader>
      <HeaderLeft />
      <HeaderRight />
    </GamePlayHeader>
  );
};

export default Header;

const GamePlayHeader = styled.header`
  display: flex;
  width: 100%;
  padding: 1rem 0;
  background-color: black;
  height: 20%;
`;
