import React, { useContext } from 'react';
import { GlobalContext } from 'util/context.js';
import { GlobalAction } from 'util/action.js';
import styled from 'styled-components';

const StyledMainPage = styled.div`
  width: 100%;
  height: 100%;
  box-shadow: 0 0 0 1px blue inset;
`;

const testPayload = {
  gameId: 123,
  playTeam: 'abc',
  home: true
}

function MainPage() {
  const { globalDispatch } = useContext(GlobalContext);

  return (
    <StyledMainPage>
      <button onClick={() => globalDispatch({ type: GlobalAction.SELECT_TEAM, payload: testPayload })}>
        test
      </button>
    </StyledMainPage>
  )
}

export default MainPage;
