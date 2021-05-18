import React, { useContext, useEffect, useState } from 'react';
import { API } from '../../common/reference';
import useFetch from '../../hooks/useFetch';
import { GamePlayContext } from '../utilComponent/context/GamePlayProvider';
import PopupFrame from '../utilComponent/popupFrame/PopupFrame';
import ScoreTable from './partial/ScoreTable';

const TeamScorePopup = ({ visible }) => {
    const [gameID, setGameID] = useState(null);
    const { gamePlayState: { teamsData }} = useContext(GamePlayContext);

    useEffect(() => {
        if (!teamsData) return;
        setGameID(teamsData.game_id);
    }, [teamsData]);

    const { loading, response } = useFetch((API + `/api/games/${gameID}/points`),
        { addProps: [visible] },
    );

    const popupOptions = { zIndex: 10, visible };
    return (
        <PopupFrame options={popupOptions}>
            <ScoreTable />
        </PopupFrame>
    );
};

export default TeamScorePopup;