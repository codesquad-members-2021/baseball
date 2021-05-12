// import { useEffect, useState } from "react";
import MatchBox from "./MatchBox/MatchBox";
import { MatchInfo as S } from "@/Components/Home/HomeStyles";
import { v4 as uuidv4 } from "uuid";
import useFetch from "@/customHooks/useFetch";
// import { getAPI } from "@/Utils/API";

const MatchInfoBody = () => {
  const matchInfoData = useFetch("http://13.209.36.131:8080/main", []);
  // const [data, setData] = useState(null);

  // useEffect(() => {
  //   getAPI.main().then((res) => {
  //     if (res && res.data) {
  //       setData(res.data);
  //     }
  //   });
  // });

  // return data ? (
  //   <S.ScrollMask>
  //     <S.MatchInfoBody>
  //       {data.games.map((match, idx) => (
  //         <MatchBox key={uuidv4()} gameId={match.gameId} {...{ match, idx }} />
  //       ))}
  //     </S.MatchInfoBody>
  //   </S.ScrollMask>
  // ): null;

  if (!matchInfoData.games) return null;
  return (
    <S.ScrollMask>
      <S.MatchInfoBody>
        {matchInfoData.games.map((match, idx) => (
          <MatchBox key={uuidv4()} gameId={match.gameId} {...{ match, idx }} />
        ))}
      </S.MatchInfoBody>
    </S.ScrollMask>
  );
};

export default MatchInfoBody;
