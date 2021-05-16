<<<<<<< HEAD
import { useContext, useState, useEffect } from 'react';
import styled, { keyframes } from 'styled-components';
import { IoIosBaseball } from 'react-icons/io';

import { gamePlayContext } from 'components/GamePlay/GamePlay';
import BallCount from 'components/GamePlay/playScreen/BallCount';

const Screen = () => {
  const {
    ballCountState,
    dispatchBallCount,
    round,
    isAttacking,
    dispatchAwayCurrentPlayerState,
    dispatchHomeCurrentPlayerState,
  } = useContext(gamePlayContext);

  const initialAttackState = isAttacking ? ['초', '공격'] : ['초', '수비'];
  const [AttackState, setAttackState] = useState(initialAttackState);
  const currentRound = Math.floor(round / 2 + 1);
  const [isClicked, setIsClicked] = useState(false);
  const changeAttackState = ([first, attack]) => {
    const _first = first === '초' ? '말' : '초';
    const _attack = attack === '공격' ? '수비' : '공격';
    return [_first, _attack];
  };
  const chooseNumber = () => Math.floor(Math.random() * 4);

  const getAction = (number) => {
    return {
      0: 'strike',
      1: 'ball',
      2: 'out',
      3: 'hit',
    }[number];
  };

  const handleClickPitch = () => {

    const ballCountAction = getAction(chooseNumber());
    dispatchBallCount({ payload: ballCountAction, attackState: isAttacking });
    setIsClicked((state) => !state);

  };

  useEffect(() => {
    const currentPlayeAction = {
      payload: 'updatePlayerHistory',
      ballCount: ballCountState,
    };
    if (isAttacking) dispatchAwayCurrentPlayerState(currentPlayeAction);
    if (!isAttacking) dispatchHomeCurrentPlayerState(currentPlayeAction);
  }, [isClicked]);

  useEffect(() => {
    if (!round) return;
    setAttackState((stateArr) => changeAttackState(stateArr));
  }, [round]);

  return (
    <StyledScreen>
      <ScreenField src="field.svg" alt="field" />
      <ScreenRound>
        {currentRound}회 {AttackState[0]} {AttackState[1]}
      </ScreenRound>
      <PitchButton onClick={handleClickPitch}>
=======
import styled, { keyframes } from 'styled-components'
import BallCount from 'components/GamePlay/playScreen/BallCount'
import { IoIosBaseball } from 'react-icons/io'
import Span from 'components/common/Span'
const Screen = () => {
  return (
    <StyledScreen>
      <ScreenField src='field.svg' alt='field' />
      <ScreenRound>2회 초 수비</ScreenRound>
      <PitchButton>
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49
        <IoIosBaseball />
      </PitchButton>
      <BallCount />
    </StyledScreen>
<<<<<<< HEAD
  );
};

export default Screen;
=======
  )
}

export default Screen
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49

const StyledScreen = styled.section`
  display: flex;
  justify-content: center;
<<<<<<< HEAD
  align-items: center;
  width: 80%;
=======
  width: 70%;
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49
  height: 100%;
  background-image: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
    url('https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png');
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
<<<<<<< HEAD
`;

const ScreenField = styled.img`
  height: fit-content;
  width: 27%;
  transform: rotate(45deg);
`;
=======
`

const ScreenField = styled.img`
  width: 34%;
  transform: rotate(45deg);
`
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49
const ScreenRound = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  color: ${({ theme }) => `${theme.colors.white}`};
  position: absolute;
  right: 2%;
  top: 4%;
<<<<<<< HEAD
`;
const rotateAnimation = keyframes`
0%{
  transform: rotate(0deg) scale(1);
}
50%{
  transform: rotate(180deg) scale(1.5);
}
100%{
  transform: rotate(360deg) scale(1);
}
`;

const PitchButton = styled.button`
  height: 5rem;
  width:fit-content;
=======
`
const rotateAnimation = keyframes`
100%{
  transform: rotate(360deg);
}
`

const scaleAnimation = keyframes`
100%{
  transform: scale(1.2)
}
`

const PitchButton = styled.button`
  height: 5rem;
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49
  position: absolute;
  left: 50%;
  top: 50%;
  cursor: pointer;
  font-size: 5rem;
  color: white;
  background: none;
  transform: translate(-50%, -50%);
<<<<<<< HEAD
  
  &:hover {
    svg {
      animation: ${rotateAnimation} 4s linear infinite;
    }
    &:active {
      svg {
        border-radius:50%;
        background-color:#e84545;
      }
    }
  }
`;
=======

  &:hover {
    svg {
      animation: ${rotateAnimation} 5s linear infinite,
        ${scaleAnimation} 2.5s ease-in infinite ;
    }
  }
`
>>>>>>> 4b215d475988c16fb3cfe6d42f78872e3919ef49
