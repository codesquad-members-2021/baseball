import styled from 'styled-components';
import ListTable from './partial/ListTable';
import PopupFrame from '../utilComponent/popupFrame/PopupFrame';
import { useContext,useEffect,useState } from "react";
import { GamePlayContext } from "../../components/utilComponent/context/GamePlayProvider";
import { API } from "../../common/reference";

const PlayerListPopup = ({ visible }) => {
    const { 
        gamePlayState: { teamsData },
        gamePlayDispatch 
    } = useContext(GamePlayContext);
    const [team,setTeam] = useState("");

    const popupOptions = {
        zIndex: 10,
        isBottom: true,
        visible,
    };

    useEffect(async () => {
        if(!teamsData) return;
        const teamData = await fetch(API+`/api/games/${teamsData.game_id}/players`).then(res => res.json());
        setTeam(teamData);
    },[visible])    

    return (
        <PopupFrame options={popupOptions}>
            {team && (
                <StyledPlayerListPopup>
                    <ListTable team={team.opponent}/>
                    <ListTable team={team.user}/>
                </StyledPlayerListPopup>
            )}
        </PopupFrame>
    );
};

export default PlayerListPopup;

// --- Styled Components ---
// 나중에 z-index도 context + reducer 관리해야할듯
const StyledPlayerListPopup = styled.div`
    display: grid;
    grid-template-columns: repeat(2, 1fr);

    margin: 12px;
    border: 3px solid ${({ theme }) => theme.colors.white};
    background-color: ${({ theme }) => theme.colors.black1};

    table:nth-child(1) {
        border-right: 3px solid ${({ theme }) => theme.colors.white};
    }
`;
