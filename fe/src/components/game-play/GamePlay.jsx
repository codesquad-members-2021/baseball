import { useEffect, useReducer, createContext, useState, useRef } from 'react';
import styled from 'styled-components';
import Score from './score/Score';
import Player from './player/Player';
import Board from './board/Board';
import Log from './log/Log';
import PopUpScore from './popup/score/Score';
import PopUpRoster from './popup/roster/Roster';
import PopUp from '../ui/PopUp';

const ScoreContext = createContext();
const MemberListContext = createContext();
const LogContext = createContext();

const memberListReducer = (state, action) => {
  let next = 0;
  const newState = state.map((member, idx) => {
    let { safety, at_bat, out, state } = member;
    if(action.type === 'out') out++
    else safety++
    at_bat++
    if(action.id === member.id) {
      next = idx + 1 === member.length ? 0 : idx + 1;
      return {...member, safety, at_bat, out, state: !state};
    }
  });
  newState[next].state = true;
  return newState;
}

const GamePlay = ({ home, away, game_id }) => {
  
  const [turn, round, member_list] = [null, null, null];
  const [inning, setInning] = useState({
    turn,
    round
  });
  // const [score, setScore] = useState(null);
  // const [memberList, memberListDispatch] = useReducer(memberListReducer, member_list); //member_list fetch해서 받아올아이
  /*
  data,

  */
  const score = { home: data.home.score, away: data.away.score };
  const memberList = { home: data.home.member_list, away: data.home.member_list };
  const pitchers = { home: data.home.pitcher, away: data.home.pitcher };
  return (
    <StyleGamePlay>
      <PopUp position='top'><PopUpScore /></PopUp>
      <PopUp position='bottom'><PopUpRoster /></PopUp>
      <StyleGamePlayGrid>
        {/* {/* <ScoreContext.Provider value={score}> */}
          <Score teamName={teamName} score={score} turn={data.turn}></Score>
        {/* </ScoreContext.Provider> */}
        <Player memberList={memberList} turn={data.turn} pitchers={pitchers}></Player>
        <Board></Board>
        <Log data={data}></Log>
      </StyleGamePlayGrid>
    </StyleGamePlay>
  );
};

const StyleGamePlay = styled.div``;

const StyleGamePlayGrid = styled.div`
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

//team 이름 props에서 받아온다고 가정
const teamName = {
  home: 'captain',
  away: 'marvel',
  game_id: 0,
};

const data = {
  round: 4, // 게임 시작시는 round,turn X
  turn: true, //(false : 말)
  home: {
    member_list: [
      {
        name: '김광진',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 0, // 번호
        state: false,
      },
      {
        name: '추신수',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 1, // 번호
        state: false,
      },
      {
        name: '이대호',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 2, // 번호
        state: false,
      },
      {
        name: '마르코',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 3, // 번호
        state: true,
      },
      {
        name: '스타브',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 4, // 번호
        state: false,
      },
      {
        name: '카일',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 5, // 번호
        state: false,
      },
      {
        name: '제이슨',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 6, // 번호
        state: false,
      },
      {
        name: '크롱',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 7, // 번호
        state: false,
      },
      {
        name: '호눅스',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 8, // 번호
        state: false,
      },
      {
        name: '제이케이',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 9, // 번호
        state: false,
      },
    ],
    pitcher: 3,
    score: 0, // 재접속 시에도 유지할 수 있도록 팀 별 점수를 받을 수 있어야 합니다!
  },
  away: {
    member_list: [
      {
        name: '고양이',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 10, // 번호
        state: false,
      },
      {
        name: '강아지',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 11, // 번호
        state: false,
      },
      {
        name: '코끼리',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 12, // 번호
        state: false,
      },
      {
        name: '얼룩말',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 13, // 번호
        state: false,
      },
      {
        name: '코뿔소',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 14, // 번호
        state: false,
      },
      {
        name: '수달',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 15, // 번호
        state: false,
      },
      {
        name: '프레리독',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 16, // 번호
        state: true,
      },
      {
        name: '하이에나',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 17, // 번호
        state: false,
      },
      {
        name: '기린',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 18, // 번호
        state: false,
      },
      {
        name: '물개',
        at_bat: 0, // 타석
        safety: 0, // 안타
        out: 0, // 아웃
        id: 19, // 번호
        state: false,
      },
    ],
    pitcher: 19,
    score: 2, // 재접속 시에도 유지할 수 있도록 팀 별 점수를 받을 수 있어야 합니다!
  },
};

export default GamePlay;
