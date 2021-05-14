import useFetch from 'hooks/useFetch'

const PutComponent = ({
  data,
  dispatchHomeCurrentPlayerState,
  dispatchAwayCurrentPlayerState,
  isAttacking
}) => {
  const option = {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(data)
  }

  const { response, loading, error } = useFetch(
    'http://baseball.san.r-e.kr/api/update_player',
    option
  )

  if(response) {
    const action = { payload: 'changeTurn', data: response }
    if (isAttacking) dispatchAwayCurrentPlayerState(action)
    if (!isAttacking) dispatchHomeCurrentPlayerState(action)
  return <></>;
  }
}

export default PutComponent

// Content-Type: application/json
// Transfer-Encoding: chunked
// Date: Wed, 12 May 2021 07:47:45 GMT
// Keep-Alive: timeout=60
// Connection: keep-alive
// accesscontrol-0allow-origin : *
