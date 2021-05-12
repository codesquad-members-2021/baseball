import React from 'react';
import PopupFrame from '../utilComponent/popupFrame/PopupFrame';
import ScoreTable from './partial/ScoreTable';

const TeamScorePopup = ({ visible }) => {
    const popupOptions = { zIndex: 10, visible };
    return (
        <PopupFrame options={popupOptions}>
            <ScoreTable />
        </PopupFrame>
    );
};

export default TeamScorePopup;