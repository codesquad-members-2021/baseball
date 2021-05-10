import { useContext } from 'react';
import { PlayableContext } from '../routes/StartScreen';

const Caption = (props) => {
  const playable = useContext(PlayableContext);
  let message = '참가할 게임을 선택하세요!';
  if (playable.home_team_status === false) {
    message = '이미 선택된 팀입니다. 다른 팀을 선택해주세요!';
  }
  return <span>{message}</span>;
};

export default Caption;
