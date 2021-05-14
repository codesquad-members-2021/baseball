
import useFetch from 'hooks/useFetch';
import qs from 'qs';

import GamePlay from 'components/GamePlay/GamePlay';


const Game = () => {
  const { team } = qs.parse(window.location.search, {
    ignoreQueryPrefix: true,
  });

  const { response, loading, error } = useFetch(
    process.env.REACT_APP_API_URL + `select_team/${team}`

  );

  if (loading) return <div>loading</div>;
  return <GamePlay response={response} />;
};


export default Game;
