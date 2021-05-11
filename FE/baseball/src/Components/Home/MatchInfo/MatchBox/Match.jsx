import { useContext } from "react";
import { RouterContext } from "@/Routes/Router";
import { Link } from "react-router-dom";
import TeamName from "./TeamName";
import VS from "./VS";
import { MatchBox as S } from "@/Components/Home/HomeStyles";

const Match = ({ gameId, match }) => {
  const { setGame } = useContext(RouterContext);
  return (
    <S.Match>
      <S.Link>
        <Link
          to="/game"
          onClick={() => setGame({ gameID: 1, selectedTeam: "Samsung Lions" })}
        >
          <TeamName
            teamName={match.away.teamName}
            isPlaying={match.away.isPlaying}
          />
        </Link>
      </S.Link>
      <VS />
      <S.Link>
        <Link
          to="/game"
          onClick={() => setGame({ gameID: 1, selectedTeam: "KIA Tigers" })}
        >
          <TeamName
            teamName={match.home.teamName}
            isPlaying={match.home.isPlaying}
          />
        </Link>
      </S.Link>
    </S.Match>
  );
};

export default Match;
