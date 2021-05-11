import React, { useEffect } from 'react';
import useFetch from 'hooks/useFetch';
import Header from 'components/GamePlay/playHeader/Header';
import Main from 'components/GamePlay/playScreen/Main';
import qs from 'qs';
// 쿼리값 읽고 데이터 페치 받은다음에 뿌려준다.
export const gamePlayContext = React.createContext();

const Game = () => {
  const { team } = qs.parse(window.location.search, {
    ignoreQueryPrefix: true,
  });

  const { response, loading, error } = useFetch(
    process.env.REACT_APP_API_URL + `/select-${team}.json`
  );
  if (loading) return <div>loading</div>;
  const [home, away] = response.team_info;

  //   const isFirstAttack = away.selected

  // 여기에서 함수를 다 정의해야할 것 같다.
  // action.type
  // reducer => dispatch => state 상태변경 > useEffect deps => render
  // useEffect

  return (
    <gamePlayContext.Provider value={{ home, away }}>
      <Header />
      <Main />
    </gamePlayContext.Provider>
  );
};

export default Game;
