import styled from 'styled-components';
import GameNumber from './GameNumber';
import Match from './Match';

const MatchBox = () => {
  return (
    <MatchBoxStyle>
      <GameNumber />
      <Match />
    </MatchBoxStyle>
  );
};

export default MatchBox;

const MatchBoxStyle = styled.div`
  border: 1px solid #fff;
  border-radius: 10px;
  margin: 10px;
  width: 100%;
  height: 100px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;
