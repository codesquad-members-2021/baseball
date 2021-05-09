import styled from 'styled-components';
import TeamRoster from './TeamRoster';
const Roster = () => {
  // team_name 필요
  return (
    <StyleRoster>
      <TeamRoster {...game_roster.home}/>
      <TeamRoster {...game_roster.away} player={true}/>
    </StyleRoster>
  );
}

// 90vw는 돼야하는데 그러면 이상함...;
const StyleRoster = styled.div`
  margin: 0 auto;
  max-width: 60vw;
  margin-top: 5rem;
  border: 3px solid #fff;
  padding: 0.5rem 1rem;
  display: grid;
  grid-template-columns: 1fr 1fr;
  & > *:first-child {
    border-right: 1.5px solid #fff;
  }
  & > *:last-child {
    border-left: 1.5px solid #fff;
  }
`;

const game_roster = {
  // 평균은 fe에서
  'home': {
    'member_list' : [
      {
        'name': '김광진',
        'at_bat': 7, // 타석
        'safety': 3, // 안타
        'out': 4, // 아웃
      },
      {
        'name': '추신수',
        'at_bat': 7, // 타석
        'safety': 5, // 안타
        'out': 2, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 11, // 타석
        'safety': 4, // 안타
        'out': 7, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 10, // 타석
        'safety': 2, // 안타
        'out': 8, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 3, // 타석
        'safety': 2, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 4, // 타석
        'safety': 1, // 안타
        'out': 3, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 6, // 타석
        'safety': 2, // 안타
        'out': 4, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 5, // 타석
        'safety': 4, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 7, // 타석
        'safety': 7, // 안타
        'out': 0, // 아웃
      },
    ],
    'player_name' : '추신수'
  },
  'away':{
    'member_list' : [
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '이대호',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
      {
        'name': '김광진',
        'at_bat': 2, // 타석
        'safety': 1, // 안타
        'out': 1, // 아웃
      },
    ],
    'player_name' : '이대호'
  }
}


export default Roster;
