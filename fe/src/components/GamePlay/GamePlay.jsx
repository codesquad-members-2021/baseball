import React, { useEffect, useState, useReducer } from 'react';
import Header from 'components/GamePlay/playHeader/Header';
import Main from 'components/GamePlay/playScreen/Main';

export const gamePlayContext = React.createContext();

const GamePlay = ({ response }) => {
  const [home, away] = response;
  const [isAttacking, setIsAttacking] = useState(null);
  const [round, setRound] = useState(0);
  const [homePlayer, setHomePlayer] = useState(home.player);
  const [awayPlayer, setAwayPlayer] = useState(away.player);

  const selectPitcherName = (team) =>
    team.player.filter((player) => player.pitcher === true)[0].name;

  const pitcherName = isAttacking
    ? selectPitcherName(home)
    : selectPitcherName(away);

  const initialBallCount = {
    count: 0,
    type: '스트라이크',
    S: 0,
    B: 0,
    O: 0,
    isHit: false,
  };
  // { count: 0, 가 없어지고 homeCount : 0 , ballCount: 0 } 으로 저장하고 리셋안함 ( )
  const getDeepCopy = (original) => JSON.parse(JSON.stringify(original));

  const ballCountReducer = (state, action) => {
    const deepCopied = getDeepCopy(state);
    deepCopied.count += 1;

    switch (action.payload) {
      case 'strike':
        deepCopied.S += 1;
        deepCopied.type = '스트라이크';
        return deepCopied;
      case 'ball':
        deepCopied.B += 1;
        deepCopied.type = '볼';
        return deepCopied;
      case 'out':
        deepCopied.O += 1;
        deepCopied.type = '아웃';
        return deepCopied;
      case 'hit':
        deepCopied.isHit = true;
        deepCopied.type = '안타';
        return deepCopied;
      case 'resetRoundBallCount':
        return { ...initialBallCount, count: 0 };
      case 'runToBase':
        return { ...initialBallCount, O: state.O, count: state.count };
      case 'threeStrike':
        return { ...initialBallCount, O: state.O + 1, count: state.count };
      default:
    }
  };

  const [ballCountState, dispatchBallCount] = useReducer(
    ballCountReducer,
    initialBallCount
  );

  const [currentPlayer, setCurrentPlayer] = useState({
    playerName: '류현진',
    uniform_number: 2,
    turn: 1,
    hit: 0,
    history: [ballCountState],
  });

  const saveDataReducer = (state, action) => {
    switch (action.payload) {
      case 'saveHomeCount':
        return { ...state, homeCount: state.homeCount + ballCountState.count };
      case 'saveAwayCount':
        return { ...state, awayCount: state.awayCount + ballCountState.count };
      case 'saveHomeScore':
        return { ...state, homeScore: state.homeScore + 1 };
      case 'saveAwayScore':
        return { ...state, awayScore: state.awayScore + 1 };
      default:
    }
  };

  const [saveDataState, dispatchSaveData] = useReducer(saveDataReducer, {
    homeCount: 0,
    homeScore: 0,
    awayCount: 0,
    awayScore: 0,
  });

  console.log(saveDataState);

  // const [homePrevPlayer, setHomePrevPlayer] = useState({});
  // const [awayPrevPlayer, setAwayPrevPlayer] = useState([{}]);

  // useEffect(() => {}, [ballCount]);
  useEffect(() => {
    setIsAttacking(away.team_info.selected);
  }, []);

  useEffect(() => {
    if (ballCountState.S === 3) {
      dispatchBallCount({ payload: 'threeStrike' });
    }
  }, [ballCountState.S]);

  useEffect(() => {
    if (ballCountState.O === 3) {
      const saveDataAction = isAttacking ? 'saveAwayCount' : 'saveHomeCount';
      dispatchSaveData({ payload: saveDataAction });
      setRound((round) => round + 1);
      setIsAttacking((state) => !state);
      dispatchBallCount({ payload: 'resetRoundBallCount' });
    }
  }, [ballCountState.O]);

  useEffect(() => {
    if (ballCountState.B === 4) dispatchBallCount({ payload: 'runToBase' });
  }, [ballCountState.B]);

  return (
    <gamePlayContext.Provider
      value={{
        round,
        isAttacking,
        pitcherName,
        home,
        away,
        ballCountState,
        dispatchBallCount,
        saveDataState,
      }}
    >
      <Header />
      <Main />
    </gamePlayContext.Provider>
  );
};

export default GamePlay;
