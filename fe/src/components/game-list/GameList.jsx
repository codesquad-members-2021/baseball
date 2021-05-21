import React, { useEffect } from 'react';
import styled from 'styled-components';
import useFetch from '../../hooks/useFetch';
import GameListItem from './GameListItem';
import { Link } from 'react-router-dom';

const DATA_LIST_URL = 'http://52.78.184.142/games';

const GameList = () => {
  const game_id = localStorage.getItem('game_id');
  if(game_id) {
    window.location.href = 'games/' + game_id;
  }
  const { data: gameListData } = useFetch(DATA_LIST_URL, 'get');
  const TITLE = 'BASEBALL GAME ONLINE';
  const DESCRIPTION = '참가할 게임을 선택하세요!';
  const gameList = gameListData?.game_list.map(({ home, away, id }, idx) => (
    <GameListItem key={idx} {...{ home, away, id, idx }} />
  ));
    
  return game_id ? null : (
    <StyledGameList>
      <StyledTitle>{TITLE}</StyledTitle>
      <StyledDescription>{DESCRIPTION}</StyledDescription>
      <StyledList>{gameList}</StyledList>
    </StyledGameList>
  );
};

const StyledGameList = styled.div`
  padding: 0 15vw;
  margin-top: 2.5rem;
`;

const StyledTitle = styled.div`
  margin-bottom: 5rem;
  font-size: 3rem;
  font-weight: 600;
  color: #fff;
  text-align: center;
`;

const StyledDescription = styled.div`
  margin-bottom: 2rem;
  font-size: 2rem;
  color: #fff;
  text-align: center;
`;

const StyledList = styled.div`
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

export default GameList;
