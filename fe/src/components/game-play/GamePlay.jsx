import { useEffect, useReducer, createContext, useState, useRef } from 'react';
import styled from 'styled-components';
import Score from './score/Score';
import Player from './player/Player';
import Board from './board/Board';
import Log from './log/Log';
import PopUpScore from './popup/score/Score';
import PopUpRoster from './popup/roster/Roster';
import PopUp from '../ui/PopUp';
import useScoreNBase from '../../hooks/useScoreNBase';
import { fetchPUT } from '../../util/api.js';
import useFetch from '../../hooks/useFetch';

export const ScoreNBaseContext = createContext();
const MemberListContext = createContext();

const memberListReducer = (state, action) => {
  if (action.type === 'init') return action.value;
  let next = 0;
  const team = action.turn ? 'home' : 'away';
  const newTeam = [...state[team]].map((member, idx, arr) => {
    let { safety, at_bat, out, status } = member;
    if (member.status) {
      if (action.type === 'out') out++;
      else safety++;
      at_bat++;
      next = idx + 1 === arr.length ? 0 : idx + 1;

      return { ...member, safety, at_bat, out, status: !status };
    } else {
      return { ...member };
    }
  });
  newTeam[next].status = true;
  return { ...state, [team]: newTeam };
};

const logListReducer = (state, action) => {
  let newState = [...state];
  const target = newState.length > 0 && { ...newState[newState.length - 1] };
  switch (action.type) {
    case 'next':
      newState.push({ ...action.value, index: action.index, history: [] });
      break;
    case 'strike':
    case 'ball':
      target.history = [...target.history, { ...action }];
      newState[newState.length - 1] = target;
      break;
    case '4ball':
    case 'safety':
    case 'out':
      target.history = [...target.history, { type: action.type, end: true }];
      target.status = false;
      newState[newState.length - 1] = target;
      break;
    case 'clear':
      newState = [];
      break;
  }
  return newState;
};

const GamePlay = ({ home, away, game_id }) => {
  const path = window.location.pathname;
  const gameID = +path.slice(7);
  const GAME_PLAY_URL = `http://52.78.184.142${path}`;
  const { data: gamePlayData } = useFetch(GAME_PLAY_URL, 'get');
  const [inning, setInning] = useState({
    turn: true,
    round: 1,
  });
  const [logList, logListDispatch] = useReducer(logListReducer, []);
  const { score, base, safetyDispatch } = useScoreNBase({
    score: { home: [0], away: [] },
    base: undefined,
  });
  console.log(gamePlayData);
  const [memberList, memberListDispatch] = useReducer(memberListReducer, null);
  const teamName = {
    home: gamePlayData?.home?.name,
    away: gamePlayData?.away?.name,
  };
  const pitchers = {
    home: gamePlayData?.home?.pitcherId,
    away: gamePlayData?.away?.pitcherId,
  };

  useEffect(() => {
    const memberListData = {
      home: gamePlayData?.home?.member_list,
      away: gamePlayData?.away?.member_list,
    };
    memberListDispatch({ type: 'init', value: memberListData });
  }, [gamePlayData]);

  useEffect(() => {
    if (memberList && memberList.home) {
      memberList[inning.turn ? 'home' : 'away'].forEach((member, index) => {
        if (member.status)
          logListDispatch({ value: { ...member }, type: 'next', index: index + 1 });
      });
    }
  }, [memberList]);

  return (
    <StyledGamePlay>
      <PopUp position='top' emptyText='상세 점수'>
        <PopUpScore score={score} teamName={teamName} />
      </PopUp>
      <PopUp position='bottom' emptyText='선수 명단'>
        <PopUpRoster memberList={memberList} />
      </PopUp>
      <StyledGamePlayGrid>
        <ScoreNBaseContext.Provider value={{ score, base, safetyDispatch }}>
          <Score teamName={teamName} turn={inning.turn} gameID={gameID}></Score>
          <Player memberList={memberList} turn={inning.turn} pitchers={pitchers}></Player>
          <Board {...{ inning, setInning, memberListDispatch, logListDispatch }}></Board>
          <Log logList={logList}></Log>
        </ScoreNBaseContext.Provider>
      </StyledGamePlayGrid>
    </StyledGamePlay>
  );
};

const StyledGamePlay = styled.div``;

const StyledGamePlayGrid = styled.div`
  display: grid;
  grid-template-columns: 3fr minmax(19.5rem, 1fr);
  grid-template-rows: minmax(14.5rem, 25vh) 75vh;
  & > div:nth-child(1),
  & > div:nth-child(3) {
    padding: 1.5rem 1.5rem 0 1.5rem;
  }
  & > div:nth-child(2),
  & > div:nth-child(4) {
    border-left: 3px solid #bbb;
    padding: 1.5rem 2rem 0rem 2rem;
  }
  & > div:nth-child(1),
  & > div:nth-child(2) {
    border-bottom: 3px solid #bbb;
    padding: 1.5rem 2rem;
  }
  & > div:nth-child(4) {
    overflow-y: scroll;
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
  }
`;

export default GamePlay;
