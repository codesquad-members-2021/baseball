import useFetch from 'hooks/useFetch';

const PutComponent = ({ data }) => {
  const option = {
    method: 'PUT',
    headers: {
      'Access-Control-Allow-Origin': '*',
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(data),
  };

  const { response } = useFetch(
    'http://baseball.san.r-e.kr/api/update_player',
    option
  );
  console.log(response);
  //   dispatchEvent(resposndata);
  return <></>;
};

export default PutComponent;

// Content-Type: application/json
// Transfer-Encoding: chunked
// Date: Wed, 12 May 2021 07:47:45 GMT
// Keep-Alive: timeout=60
// Connection: keep-alive
// accesscontrol-0allow-origin : *
