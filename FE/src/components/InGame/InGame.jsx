import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import styled from 'styled-components';

const InGame = () => {
  return (
    <StyledInGame>
      <div className="blind"></div>
    </StyledInGame>
  );
};

export default InGame;

const StyledInGame = styled.div`
  width: 100%;
  height: 100%;
  .blind {
    width: 100%;
    height: 100%;
    border: red 1px solid;
  }
`;
