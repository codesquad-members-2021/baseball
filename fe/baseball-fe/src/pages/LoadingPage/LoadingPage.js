import styled from 'styled-components';
import { useEffect, useContext } from 'react';
import usePolling from 'util/hook/usePolling.js';
import { GlobalContext } from 'util/context.js';
import { GlobalAction } from 'util/action.js';
import API from 'util/API.js';

function LoadingPage() {
  const { globalState, globalDispatch } = useContext(GlobalContext);
  const { response, isLoading, setPolling } = usePolling({
    URL: API.start({ gameId: globalState.gameId, userId: globalState.userId }),
    completeFn: res => res.status === 'START_OK'
  });

  useEffect(() => {
    setPolling(true);

    // FOR TEST
    // setTimeout(() => {
    //   setPolling(false);
    // }, 3000);
  }, []);

  useEffect(() => {
    if (isLoading === true || !response)
      return;

    setPolling(false);
    const mode = getCurrMode(response.body);

    globalDispatch({ 
      type: GlobalAction.GAME_START,
      payload: {
        initialGameState: { ...response.body, mode }
      }
    });
    // gameDispatch({
    //   type: GameAction.START,
    //   payload: {
    //     ...response.body,
    //     mode
    //   }
    // });
  }, [isLoading]);

  const getCurrMode = (data) =>  {
    return globalState.home ? data.home.mode : data.away.mode;
  }

  return (
    <StyledLoadingPage>
      {response?.message ?? 'Loading...'}
    </StyledLoadingPage>
  )
}

export default LoadingPage;

const StyledLoadingPage = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: black;
  color: white;
  font-weight: 800;
`
