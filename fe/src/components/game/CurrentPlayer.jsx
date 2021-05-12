import React from "react";

const CurrentPlayer = ({ player }) => {
  return (
    <div>
      <div>{player.role}</div>
      <div>
        <span>{player.name}</span>
        <span>
          {player.role === "투수" ? `#${player.pitchCount}` : `${player.plateAppearances}타석 ${player.hits}안타`}
        </span>
      </div>
    </div>
  );
};

export default CurrentPlayer;
