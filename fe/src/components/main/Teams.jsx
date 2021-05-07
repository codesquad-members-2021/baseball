import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

const Teams = ({ teamSet }) => {
  const [selectedTeamSet, setSelectedTeamSet] = useState(null);

  const setTeams = (teamName, teamId, idx) => {
    const counterTeamId = idx ? teamSet[0].id : teamSet[1].id;
    const counterTeamName = teamSet[idx ? 0 : 1].name;
    const isHome = idx === 1;
    // 데이터베이스에 현재팀, 반대팀 정보 저장하는 로직 짜기
    // useEffect(() => {
    //   fetch("http://localhost:3000/teamSet", {
    //     body: {
    //       myTeam: {id: teamId, home: isHome},
    //       counterTeam: {id: counterTeamId, home: !isHome},
    //     },
    //   });

    // }, [selectedTeam]);
    const teams = {
      myTeam: { id: teamId, name: teamName, home: isHome },
      counterTeam: { id: counterTeamId, name: counterTeamName, home: !isHome },
    };
    setSelectedTeamSet(teams);
    localStorage.setItem("Teams", JSON.stringify(teams));
  };

  return (
    <div>
      {teamSet.map((team, i) => (
        <Link to="/game" onClick={() => setTeams(team.name, team.id, i)}>
          {team.name}
        </Link>
      ))}
    </div>
  );
};

export default Teams;

// [
//   [
//     { id: 2, name: "Twins" },
//     { id: 5, name: "Tigers" },
//   ],
//   [
//     { id: 0, name: "Bears" },
//     { id: 7, name: "Dinos" },
//   ],
//   [
//     { id: 1, name: "Landers" },
//     { id: 3, name: "Giants" },
//   ],
//   [
//     { id: 4, name: "Eagles" },
//     { id: 6, name: "Lions" },
//   ],
// ];
