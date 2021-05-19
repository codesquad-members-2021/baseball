import styled from 'styled-components';
import GameSelect from 'components/GameHome/GameSelect';
import React from 'react';

export const GameItemContext = React.createContext();

const GameItem = ({ game_id, home, away, isStart }) => {
  return (
    <GameItemContext.Provider value={{ home, away, isStart }}>
      <ItemWrapper>
        <GameTitle>GAME {game_id}</GameTitle>
        <GameSelect />
      </ItemWrapper>
    </GameItemContext.Provider>
  );
};

export default GameItem;

const ItemWrapper = styled.li`
  width: 35rem;
  height: 8rem;
  display: flex;
  flex-direction: column;
  align-items: center;
  margin: 1rem 0;
  padding: 1rem 0;
  background-color: rgba(255, 255, 255, 0.8);
  border-radius: 2.5rem;
`;

const GameTitle = styled.h6`
  color: #cf0000;
  font-size: 1.2rem;
`;
