import React from 'react';
// const { atBat, plate_appearance, outCountCount } = member;

const RosterPlayer = ({ name, atBat, plate_appearance, outCount, player_name }) => {
  
  const getAverage = (atBat, plate_appearance) => (plate_appearance / atBat) ? (plate_appearance / atBat).toFixed(3) : 0;
  const class_name = 'roster--member' + (name === player_name ? ' active' : '');
  return (
    <li className={class_name}>
      <div>{name}</div>
      <div>{atBat}</div>
      <div>{plate_appearance}</div>
      <div>{outCount}</div>
      <div>{getAverage(atBat, plate_appearance)}</div>
    </li>
  );
};

export default RosterPlayer;