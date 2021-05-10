import React, { useContext } from "react";
import { Link } from "react-router-dom";
import { GlobalContext } from "../../App";
const mockData = {
  inning: {
    out: 0, // 전체 아웃인듯?
    inningNumber: 1,
    role: "수비",
    cycle: "초",
  },
  nextHitter: {
    playerBattingOrder: 2,
    teamId: 1,
    playerName: "eve",
    historyList: [],
  },
  expeditionTeam: {
    name: "Captain",
    totalScore: 0,
  },
  homeTeam: {
    name: "Twins",
    totalScore: 0,
  },
  pitcher: {
    role: "투수",
    name: "Jung",
    pitchCount: 0,
    plateAppearances: 0,
    hits: 0,
  },
  hitter: {
    role: "타자",
    name: "eve",
    pitchCount: 0,
    plateAppearances: 0,
    hits: 0,
  },
  teamLog: {
    playerLog: [
      {
        playerBattingOrder: 1,
        teamId: 1,
        playerName: "adela",
        historyList: [
          {
            id: 1,
            actionName: "S",
            strike: 1,
            ball: 0,
            out: 0,
          },
          {
            id: 2,
            actionName: "S",
            strike: 2,
            ball: 0,
            out: 0,
          },
          {
            id: 3,
            actionName: "S",
            strike: 3,
            ball: 0,
            out: 1,
          },
        ],
      },
    ],
  },
};

const Teams = ({ teamSet }) => {
  const { setMyTeam, setCounterTeam, setHomeTeam, setExpeditionTeam, setCurrHitter, setCurrPitcher, setCurrInning, setCurrTeamLog } = useContext(GlobalContext);
  const setTeams = (teamName, teamId, idx) => {
    const counterTeamId = idx ? teamSet[0].id : teamSet[1].id;
    const counterTeamName = teamSet[idx ? 0 : 1].name;
    const isHome = idx === 1;
    // const homeTeam = isHome ? { id: teamId, name: teamName } : { id: counterTeamId, name: counterTeamName };
    setMyTeam({ id: teamId, name: teamName });
    setCounterTeam({ id: counterTeamId, name: counterTeamName });
    setHomeTeam(mockData.homeTeam);
    setExpeditionTeam(mockData.expeditionTeam);
    // setCurrGameState([...mockData]);
    setCurrPitcher({
      role: mockData.pitcher.role,
      name: mockData.pitcher.name,
      pitchCount: mockData.pitcher.pitchCount,
    });
    setCurrHitter({
      role: mockData.hitter.role,
      playerBattingOrder: mockData.nextHitter.playerBattingOrder,
      teamId: mockData.nextHitter.teamId,
      historyList: [...mockData.nextHitter.historyList],
      name: mockData.hitter.name,
      plateAppearances: mockData.hitter.plateAppearances,
      hits: mockData.hitter.hits,
    });
    setCurrInning(mockData.inning);
    setCurrTeamLog([...mockData.teamLog.playerLog]);

    // 데이터베이스에 현재팀, 반대팀 정보 저장하는 로직 짜기
    // useEffect(() => {
    // fetch("http://ec2-15-165-82-124.ap-northeast-2.compute.amazonaws.com:8080/game", {
    //   method: "post",
    //   headers: {
    //     accept: "application/json",
    //     "Content-Type": "application/json;charset=UTF-8",
    //   },
    //   body: {
    //     myTeamId: teamId,
    //     counterTeamId: counterTeamId,
    //     isHome: isHome,
    //   },
    // })
    //   .then((res) => res.json())
    //   .then((res) => console.log(res));
    // }, []);
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
