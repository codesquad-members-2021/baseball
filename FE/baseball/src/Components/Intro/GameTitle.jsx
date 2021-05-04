import styled from 'styled-components';

const GameTitle = () => {
  return (
    <GameTitleStyle>
      Team illy'swing BASEBALL GAME!!! <br />
      comming soon...
    </GameTitleStyle>
  );
};

export default GameTitle;

const GameTitleStyle = styled.div`
  text-align: center;
`;
