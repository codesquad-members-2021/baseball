import React from 'react';
import styled from 'styled-components';
import PopupFrame from '../utilComponent/popupFrame/PopupFrame';
import ScoreTable from './partial/ScoreTable';
import Turn from './partial/Turn';

const TeamScorePopup = () => {
    // Turn 은 position absolute를 통해 top 값을 상황에 따라 주어지게 하여 위치조절하기.

    return (
        <PopupFrame zIndex={10}>
            <Scoreboard>
                <Turn />
                <ScoreTable />
            </Scoreboard>
        </PopupFrame>
    );
};

const Scoreboard = styled.div`
    width: 90%;
    height: 100px;
    display: flex;
    justify-content: center;
    padding: 20px;
    margin: auto;
    background-color: black;
    border: 1px solid white;
    color: white;
    font-size: 25px;
`;

export default TeamScorePopup;
