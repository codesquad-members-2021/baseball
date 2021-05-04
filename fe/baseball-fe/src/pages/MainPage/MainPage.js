import { useContext } from 'react';
import { GlobalContext } from 'util/context.js';
import { GlobalAction } from 'util/action.js';
import Message from './Message.js';
import GameList from './GameList.js';
import styled from 'styled-components';

const testPayload = {
  gameId: 123,
  playTeam: 'abc',
  home: true
}

function MainPage() {
  const { globalDispatch } = useContext(GlobalContext);

  return (
    <StyledMainPage>
      <div>BASEBALL GAME ONLINE</div>
      <Message/>
      <GameList/>
      {/* <button onClick={() => globalDispatch({ type: GlobalAction.SELECT_TEAM, payload: testPayload })}>
        게임시작
      </button> */}
    </StyledMainPage>
  )
}

export default MainPage;

const StyledMainPage = styled.div`
  width: 100%;
  height: 100%;
  box-shadow: 0 0 0 1px blue inset;
  background-color: black;

  & > div {
    color: #fff;
    font-weight: 600;
    font-size: 2.5rem;
    position: absolute;
    top: 25%;
    left: 50%;
    transform: translate(-50%, -50%);
  }
`;
