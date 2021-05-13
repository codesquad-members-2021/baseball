import React, { useState, useContext, useEffect } from 'react';
import styled from 'styled-components';
import useScoreNBase from '../../../hooks/useScoreNBase';
import { ScoreNBaseContext } from '../GamePlay';

const Screen = ({ handleStrike, handleBall, handleSafety, ballCount, turn }) => {
  const { base, safetyDispatch } = useContext(ScoreNBaseContext);
  const [isTransition, setIsTransition] = useState(false);
  const [runFirstBase, setRunFirstBase] = useState(false);
  const [currentPower, setCurrentPower] = useState(0);

  const playerRunType = [
    'translateX(19.6rem)',
    'translateY(-19.6rem)',
    'translateX(-19.6rem)',
    'translateY(19.6rem)',
  ];

  const handleTransitionEnd = async () => {
    if (currentPower === 0) return;
    setRunFirstBase(false);
    setCurrentPower(currentPower - 1);
    safetyDispatch({ type: 'onBase', turn, runFirstBase });
    setIsTransition(false);
  };

  const handlePitchClick = () => {
    const randomNum = Math.ceil(Math.random() * 100);
    if (randomNum <= 60) {
      //스트라이크
      handleStrike();
    } else if (randomNum <= 80) {
      //볼
      if (ballCount.ball === 3) {
        if (base[3]) {
          //4번 API {"game_id": 7,"home": 1,"away": 2, "round": 3} 모든정보 컨텍스트로
        }
        setIsTransition(true);
        setRunFirstBase(true);
        setCurrentPower(1);
      }
      handleBall();
    } else {
      //안타
      if (base[3]) {
        //4번 API {"game_id": 7,"home": 1,"away": 2, "round": 3} 모든정보 컨텍스트로
      }
      setIsTransition(true);
      setRunFirstBase(true);
      handleSafety();
      if (randomNum <= 100) {
        //1루타
        setCurrentPower(1);
      } else if (randomNum <= 6) {
        //2루타
        setCurrentPower(2);
      } else if (randomNum <= 3) {
        //3루타
        setCurrentPower(3);
      } else {
        //홈런
        setCurrentPower(4);
      }
    }
  };

  const baseList = Object.entries(base).map(([baseNum, status], idx) => (
    <div className='base' key={idx}>
      <div className='runner'></div>
    </div>
  ));

  return (
    <StyledScreen>
      <StyledPitch onClick={handlePitchClick}>PITCH</StyledPitch>
      <StyledGround
        playerRunType={playerRunType}
        currentPower={currentPower}
        runFirstBase={runFirstBase}
        isTransition={isTransition}
        base={base}
        onTransitionEnd={handleTransitionEnd}
      >
        <div className='base home'>
          <div className='runner'></div>
        </div>
        {baseList}
      </StyledGround>
    </StyledScreen>
  );
};

const StyledScreen = styled.div`
  position: relative;
  align-self: center;
`;
const StyledPitch = styled.button`
  position: absolute;
  top: calc(50% - 1.5rem);
  left: calc(50% - 5rem);
  display: inline;
  width: 10rem;
  height: 3rem;
  font-size: 2rem;
  font-weight: 600;
  border: 2px solid #fff;
  border-radius: 0.5rem;
  background: transparent;
  color: #fff;
  cursor: pointer;
  transition: all 0.1s linear;
  z-index: 1;
  &:hover {
    background-color: #fff;
    color: #000;
  }
`;

const StyledGround = styled.div`
  position: relative;
  border: 3px solid #fff;
  width: 20rem;
  height: 20rem;
  margin: auto;
  transform: rotate(-45deg);
  .runner {
    width: 1.5rem;
    height: 1.5rem;
    background-color: red;
    transition: ${({ isTransition }) => (isTransition ? 'all 0.5s' : '')};
  }

  .home {
    z-index: 4;
  }
  .base {
    position: absolute;
    display: flex;
    align-items: center;
    justify-content: center;
    background-color: #fff;
    width: 2rem;
    height: 2rem;
    &:nth-child(1) {
      bottom: -1rem;
      left: -1rem;
      .runner {
        background-color: ${({ runFirstBase }) => (runFirstBase ? 'red' : 'rgba(0,0,0,0)')};
        transform: ${({ playerRunType, currentPower, runFirstBase }) =>
          runFirstBase && currentPower > 0 ? `${playerRunType[0]} rotate(45deg)` : `rotate(45deg)`};
      }
      &:before {
        content: '';
        background-color: #fff;
        width: 2.8284712rem;
        height: 4rem;
        position: absolute;
        bottom: -2.45rem;
        left: -1.88rem;
        transform: rotate(45deg);
      }
    }
    &:nth-child(2) {
      z-index: 3;
      bottom: -1rem;
      right: -1rem;
      .runner {
        background-color: ${({ base }) => (base[1] ? 'red' : 'rgba(0,0,0,0)')};
        transform: ${({ playerRunType, currentPower }) =>
          currentPower > 0 ? `${playerRunType[1]} rotate(45deg)` : `rotate(45deg)`};
      }
    }
    &:nth-child(3) {
      z-index: 2;
      top: -1rem;
      right: -1rem;
      .runner {
        background-color: ${({ base }) => (base[2] ? 'red' : 'rgba(0,0,0,0)')};
        transform: ${({ playerRunType, currentPower }) =>
          currentPower > 0 ? `${playerRunType[2]} rotate(45deg)` : `rotate(45deg)`};
      }
    }
    &:nth-child(4) {
      z-index: 1;
      top: -1rem;
      left: -1rem;
      .runner {
        background-color: ${({ base }) => (base[3] ? 'red' : 'rgba(0,0,0,0)')};
        transform: ${({ playerRunType, currentPower }) =>
          currentPower > 0 ? `${playerRunType[3]} rotate(45deg)` : `rotate(45deg)`};
      }
    }
  }
`;

export default Screen;
