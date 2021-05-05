import styled from 'styled-components';
import GameTitle from '@/Components/Intro/GameTitle';
import { Link } from 'react-router-dom';

const GameStartButton = () => {
  return (
    <Link to="/home">
      <GameStartButtonStyle>
        <GameTitle />
      </GameStartButtonStyle>
    </Link>
  );
};
export default GameStartButton;

const GameStartButtonStyle = styled.div`
  width: 650px;
  height: 100px;
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  font-size: 30px;
  transition: all ease-in-out 0.4s;
  font-weight: 700;

  :hover {
    background: #333;
  }
  :active {
    background: #111;
  }
`;
