import { useReducer } from "react";
import InningInfo from "./InningInfo";
import PitchButton from "./PitchButton";
import GameDisplay from "./GameDisplay/GameDisplay";
import BallCountBoard from "./BallCountBoard/BallCountBoard";
import { BACKGROUND_URL } from "@/Utils/const";
import { GamePlayground as S } from "@/Components/Game/GameStyles";

const reducer = (state, action) => {
  switch (action.type) {
    case "STRIKE":
      return { ...state, strike: state.strike + 1 };
    case "BALL":
      return { ...state, ball: state.ball + 1 };
    default:
      return;
  }
};

const GamePlayground = () => {
  const initialState = {
    strike: 2,
    ball: 2,
    out: 1,
    inning: 1,
    inningCount: "초", // or 말
    isDefense: true,
  };
  const [state, dispatch] = useReducer(reducer, initialState);

  return (
    <S.GamePlayground>
      <S.Background src={BACKGROUND_URL} />
      <BallCountBoard ballCount={state} />
      <InningInfo inningInfo={state} />
      <GameDisplay />
      <PitchButton dispatch={dispatch} />
    </S.GamePlayground>
  );
};

export default GamePlayground;
