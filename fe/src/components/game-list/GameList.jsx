import React from 'react';
import styled from 'styled-components';
import GameListItem from './GameListItem';

const GameList = (props) => {
  const TITLE = 'BASEBALL GAME ONLINE';
  const DESCRIPTION = '참가할 게임을 선택하세요!';
  const gameList = game_list.map(({ home, away, game_id }, idx) => (
    <GameListItem key={idx} {...{ home, away, game_id, idx }} />
  ));

  return (
    <StyleGameList>
      <StyleTitle>{TITLE}</StyleTitle>
      <StyleDescription>{DESCRIPTION}</StyleDescription>
      <StyleList>{gameList}</StyleList>
    </StyleGameList>
  );
};

const StyleGameList = styled.div`
  padding: 0 15vw;
  margin-top: 2.5rem;
`;

const StyleTitle = styled.div`
  margin-bottom: 5rem;
  font-size: 3rem;
  font-weight: 600;
  color: #fff;
  text-align: center;
`;

const StyleDescription = styled.div`
  margin-bottom: 2rem;
  font-size: 2rem;
  color: #fff;
  text-align: center;
`;

const StyleList = styled.div`
  max-width: 50rem;
  margin: 0 auto;
  padding-left: 1.0625rem;
  max-height: 31rem;
  overflow-y: scroll;
  mask-image: linear-gradient(to top, transparent, black),
    linear-gradient(to left, transparent 17px, black 17px);
  mask-size: 100% 20000px;
  mask-position: left bottom;
  transition: mask-position 0.3s;
  &:hover {
    mask-position: left top;
  }
  &::-webkit-scrollbar {
    width: 0.875rem;
  }
  &::-webkit-scrollbar-thumb {
    background-color: #999;
    border-radius: 0.375rem;
    &:hover {
      background-color: #555;
    }
  }
  &::-webkit-scrollbar-track {
    background-color: transparent;
  }
`;

const game_list = [
  {
    home: '베리베리 스트로베리',
    away: '엄마는 외계인',
    game_id: 0,
  },
  {
    home: 'twins',
    away: 'tigers',
    game_id: 1,
  },
  {
    home: 'rockets',
    away: 'dodgers',
    game_id: 2,
  },
  {
    home: 'rockets',
    away: 'dodgers',
    game_id: 2,
  },
  {
    home: 'rockets',
    away: 'dodgers',
    game_id: 2,
  },
  {
    home: 'rockets',
    away: 'dodgers',
    game_id: 2,
  },
];

export default GameList;
