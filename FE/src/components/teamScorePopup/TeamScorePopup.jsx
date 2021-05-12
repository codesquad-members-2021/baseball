import React from 'react';
import PopupFrame from '../utilComponent/popupFrame/PopupFrame';
import ScoreTable from './partial/ScoreTable';

const TeamScorePopup = ({ visible, callBackFrameLeave }) => {
    // Turn 은 position absolute를 통해 top 값을 상황에 따라 주어지게 하여 위치조절하기.

    const popupOptions = { zIndex: 10, visible, callBackFrameLeave };
    return (
        <PopupFrame options={popupOptions}>
            <ScoreTable />
        </PopupFrame>
    );
};

export default TeamScorePopup;