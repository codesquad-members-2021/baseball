import useFetch from 'hooks/useFetch';
import { useEffect, useState, useContext } from 'react';
import { gamePlayContext } from 'components/GamePlay/GamePlay';

const PutComponent = ({
  data,
  dispatchHomeCurrentPlayerState,
  dispatchAwayCurrentPlayerState,
  isAttacking,
  type,
}) => {
  const { setLog, homeCurrentPlayerState, awayCurrentPlayerState } =
    useContext(gamePlayContext);

  const option = {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  };

  const { response, loading, error } = useFetch(
    'http://baseball.san.r-e.kr/api/update_player',
    option
  );

  useEffect(() => {
    if (response) {
      if (isAttacking)
        setLog((log) => [
          { ...awayCurrentPlayerState, previousAction: type },
          ...log,
        ]);
      if (!isAttacking)
        setLog((log) => [
          { ...homeCurrentPlayerState, previousAction: type },
          ...log,
        ]);
      const action = { payload: 'changeTurn', data: response };
      if (isAttacking) dispatchAwayCurrentPlayerState(action);
      if (!isAttacking) dispatchHomeCurrentPlayerState(action);
    }
  });
  return <></>;
};

export default PutComponent;

// Content-Type: application/json
// Transfer-Encoding: chunked
// Date: Wed, 12 May 2021 07:47:45 GMT
// Keep-Alive: timeout=60
// Connection: keep-alive
// accesscontrol-0allow-origin : *
