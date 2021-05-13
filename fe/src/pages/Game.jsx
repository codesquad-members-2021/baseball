import React, { useEffect, useState } from 'react';
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

  const [ballCount, setBallCount] = useState({
    count: 1,
    type: '스트라이크',
    s: 0,
    b: 0,
    isHit: false,
  });

  // const [homePrevPlayer, setHomePrevPlayer] = useState({});
  // const [awayPrevPlayer, setAwayPrevPlayer] = useState([{}]);
  const [currentPlayer, setCurrentPlayer] = useState({
    playerName: '류현진',
    uniform_number: 2,
    turn: 1,
    hit: 0,
    history: [ballCount],
  });

  // useEffect(() => {}, [ballCount]);

  // useEffect(() => {}, [out]);

  if (loading) return <div>loading</div>;
  const [home, away] = response.team_info;
  const isFirstAttack = away.selected;

  return (
    <gamePlayContext.Provider value={{ home, away }}>
      <Header />
      <Main />
    </gamePlayContext.Provider>
  );
};

export default Game;
