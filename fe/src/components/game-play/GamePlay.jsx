import styled from 'styled-components';
import Score from './score/Score';
import Player from './player/Player';
import Board from './board/Board';
import Log from './log/Log';

const GamePlay = (props) => (
  <StyleGamePlay>
    <StyleGamePlayGrid>
      <Score></Score>
      <Player></Player>
      <Board></Board>
      <Log></Log>
    </StyleGamePlayGrid>
  </StyleGamePlay>
);

const StyleGamePlay = styled.div``;

const StyleGamePlayGrid = styled.div`
  display: grid;
  grid-template-columns: 3fr 1fr;
  grid-template-rows: 27vh 73vh;
  & > div:nth-child(1), & > div:nth-child(2) {
    border-bottom: 3px solid #bbb;
  }
  & > div:nth-child(1), & > div:nth-child(3) {
    padding: 1.5rem 1.5rem 0 1.5rem;
  }
  & > div:nth-child(2), & > div:nth-child(4) {
    border-left: 3px solid #bbb;
    padding: 1.5rem 2rem 0rem 2rem;
  }
`;

const data = {
  'home': {
    'member_list' : [
      {
        'name': '김광진',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 0,// 번호 
        'state': false
      },
      {
        'name': '추신수',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 1,// 번호 
        'state': false
      },
      {
        'name': '이대호',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 2,// 번호 
        'state': false
      },
      {
        'name': '마르코',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 3,// 번호 
        'state': true
      },
      {
        'name': '스타브',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 4,// 번호 
        'state': false
      },
      {
        'name': '카일',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 5,// 번호 
        'state': false
      },
      {
        'name': '제이슨',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 6,// 번호 
        'state': false
      },
      {
        'name': '크롱',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 7,// 번호 
        'state': false
      },
      {
        'name': '호눅스',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 8,// 번호 
        'state': false
      },
      {
        'name': '제이케이',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 9,// 번호 
        'state': false
      },
    ],
    'pitcher': 3,
    'score': 0 // 재접속 시에도 유지할 수 있도록 팀 별 점수를 받을 수 있어야 합니다!
  },
  'away':{
    'member_list' : [
      {
        'name': '고양이',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 10,// 번호 
        'state': false
      },
      {
        'name': '강아지',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 11,// 번호 
        'state': false
      },
      {
        'name': '코끼리',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 12,// 번호 
        'state': false
      },
      {
        'name': '얼룩말',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 13,// 번호 
        'state': false
      },
      {
        'name': '코뿔소',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 14,// 번호 
        'state': false
      },
      {
        'name': '수달',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 15,// 번호 
        'state': false
      },
      {
        'name': '프레리독',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 16,// 번호 
        'state': true
      },
      {
        'name': '하이에나',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 17,// 번호 
        'state': false
      },
      {
        'name': '기린',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 18,// 번호 
        'state': false
      },
      {
        'name': '물개',
        'at_bat': 0, // 타석
        'safety': 0, // 안타
        'out': 0, // 아웃
        'id': 19,// 번호 
        'state': false
      },
    ],
    'pitcher': 3,
    'score': 2 // 재접속 시에도 유지할 수 있도록 팀 별 점수를 받을 수 있어야 합니다!
  }
}

export default GamePlay;