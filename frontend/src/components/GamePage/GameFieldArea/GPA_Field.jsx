import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import { theme, Span } from '../../Style/Theme';
import { ReactComponent as Field } from './Field.svg';
import { ReactComponent as Ghost } from './ghost.svg';
import API from '../../Hook/API';
import {
  useGameState,
  useDispatch,
  useLogState,
  useLogDispatch,
} from '../../GameContext';
// import GhostAnimation from './GPA_Animation';

const GPA_Field = ({ type, gameId }) => {
  const { state } = useGameState();
  const dispatch = useDispatch();
  const logDispatch = useLogDispatch();
  const [inning, setInning] = useState(
    state.score ? state.gameStatusDTO.inning : 1
  );
  const currentInning = state.score ? state.gameStatusDTO.inning : 1;
  const [isTop, setIsTop] = useState(type === 'Attack' ? '공격' : '수비');
  const [currentType, setCurrentType] = useState(type);
  const [isInit, setIsInit] = useState('초');

  useEffect(() => {
    state.score && setIsTop(state.gameStatusDTO.top ? '공격' : '수비');
  }, [state]);

  useEffect(() => {
    state.score && isInit === '초' ? setIsInit('말') : setIsInit('초');
    state.score && currentType === 'Attack'
      ? setCurrentType('Defense')
      : setCurrentType('Attack');
  }, [isTop]);

  const getPitchResult = async () => {
    const response = await API.post.pitch(gameId);
    dispatch({ type: 'pitch', payload: response });
    logDispatch({ type: 'log', payload: response });
  };

  let interval;

  useEffect(() => {
    if (currentType === 'Defense') {
      interval = setInterval(() => {
        getPitchResult();
      }, 3000);
    }
    return () => clearInterval(interval);
  }, []);

  const handleClick = () => {
    getPitchResult();
  };

  const move =
    state.pitchResult && state.pitchResult.playType === 'HITS' ? true : false;

  return (
    <>
      {currentType === 'Attack' && <PITCH onClick={handleClick}>PITCH</PITCH>}
      <FieldArea>
        <GameState>
          {currentInning}회{isInit} {isTop}
        </GameState>
        <FieldSVG />
        {/* <GhostAnimation move={move} /> */}
      </FieldArea>
    </>
  );
};

const PITCH = styled.button`
  position: absolute;
  top: 26rem;
  left: 3rem;
  cursor: pointer;
  z-index: 9999;
  background-color: ${theme.colors.transparent};
  font-size: ${theme.fontSize.XX_large};
  font-weight: ${theme.fontWeight.Bold};
  color: ${theme.colors.white};
  border: 5px solid ${theme.colors.white};
`;
const FieldArea = styled.div`
  position: relative;
`;

const FieldSVG = styled(Field)`
  position: absolute;
  top: 23rem;
  left: 3rem;
`;

const GameState = styled(Span)`
  position: absolute;
  top: 50rem;
  right: 23rem;
  font-size: ${theme.fontSize.X_large};
  font-weight: ${theme.fontWeight.light};
  color: ${theme.colors.white};
`;
export default GPA_Field;
