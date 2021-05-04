import styled from 'styled-components';

const GameTitle = () => {
  return (
    <GameTitleStyle>
      Team illy's Baseball game! <br />
      comming soon...
    </GameTitleStyle>
  );
};

export default GameTitle;

const GameTitleStyle = styled.div`
  text-align: center;
`;
