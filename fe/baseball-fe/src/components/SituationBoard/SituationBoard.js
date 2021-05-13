import { useContext } from 'react';
import styled from 'styled-components';
import { GameContext } from 'util/context.js';

import BallCount from './BallCount.js';
import Field from './Field/Field.js';
import Baseball from 'util/baseball.js';

function SituationBoard({ className }) {
  const { gameState, gameDispatch, setRecords } = useContext(GameContext);

  const handleClickPitch = () => {
    const result = Baseball.pitch();
    setRecords(records => [...records,
      Baseball.generateRecord({ action: result, gameState })
    ]);
    gameDispatch({ type: result });
  }

  return (
    <StyledSituationBoard className={className}>
      <BallCount/>
        <div className='inning'>
          {gameState.game_info.current_inning}회
          {gameState.game_info.frame === "TOP" ? " 초" : " 말"}
          {gameState.mode === "FIELDING" ? " 수비" : " 공격"}
        </div>
      <Field/>
      {gameState.mode === 'FIELDING' && gameState.batter && <button className='pitch-btn' onClick={handleClickPitch}>PITCH</button>}
    </StyledSituationBoard>
  );
}

export default SituationBoard;

const StyledSituationBoard = styled.div`
  box-shadow: 0 0 0 1px black inset;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-between;
  position: relative;
  background-color: black;
  color: white;
  font-weight: 800;
  overflow: hidden;
  
  .inning {
    box-shadow: 0 0 0 1px red inset;
    position: absolute;
    align-self: flex-end;
    width: 100px;
    height: 100px;
  }

  .pitch-btn {
    width: 12rem;
    height: 4rem;
    position: absolute;

    top: calc(50% - 1rem);
    left: calc(50% - 6rem);
  }
`;
