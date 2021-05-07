import React from 'react';
import GamePage from '../GamePage';
const DefenseMode = ({ match }) => {
  const id = match.params;
  return (
    <>
      <div>수비모드</div>
      <GamePage data={id} />
    </>
  );
};

export default DefenseMode;
