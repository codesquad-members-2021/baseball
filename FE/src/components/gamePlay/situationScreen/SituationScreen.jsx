import styled from "styled-components";
import Situation from "./situation/Situation";
import { useContext, useState, useEffect } from "react";
import { GamePlayContext } from "../../utilComponent/context/GamePlayProvider";


const SituationScreen = () => {
    const { 
        gamePlayState: { teamsData ,gameProgress },
        gamePlayDispatch 
    } = useContext(GamePlayContext);
    const { userHitterIdx, opponentHitterIdx, attackerTeamName, hitter, situation } = gameProgress;

    // 팀구별
    const hitterNumber = () => {
        if(attackerTeamName === teamsData.opponent.team_name) {
            return String(teamsData.opponent.players.findIndex(v => v.name === hitter.name))
        } else if(attackerTeamName === teamsData.user.team_name) {
            return String(teamsData.user.players.findIndex(v => v.name === hitter.name))
        }
    }

    const [screenList,setScreenList] = useState("");
    console.log(teamsData)

    useEffect(() => {
        if(!hitter) return;
        // if(screenList.length===1) return;
        screenList ? setScreenList([...screenList, [String(hitter.name),hitterNumber()]]) : setScreenList([[String(hitter.name),hitterNumber()]]);
    },[hitter]);
   

    return (
        <StyledSituationScreen>
            {screenList&&screenList.map((_, i) => <Situation key={i} number={_[1]} name={_[0]} situation={situation}/>)}
        </StyledSituationScreen>
    );
};

export default SituationScreen;

// --- Styled Components ---
const StyledSituationScreen = styled.div`

`;