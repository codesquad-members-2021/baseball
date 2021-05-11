import React from 'react';

const RosterPlayer = ({ name, at_bat, safety, out, player_name }) => {
  const getAverage = (at_bat, safety) => (safety / at_bat) ? (safety / at_bat).toFixed(3) : 0;
  const class_name = 'roster--member' + (name === player_name ? ' active' : '');
  return (
    <li className={class_name}>
      <div>{name}</div>
      <div>{at_bat}</div>
      <div>{safety}</div>
      <div>{out}</div>
      <div>{getAverage(at_bat, safety)}</div>
    </li>
  );
};

export default RosterPlayer;