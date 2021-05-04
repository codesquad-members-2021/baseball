import React from 'react'
import styled from 'styled-components';
import ScoreTable from "./scoreTable/ScoreTable";
import Turn from "./turn/Turn";

const TeamScore = () => {
    // Turn 은 position absolute를 통해 top 값을 상황에 따라 주어지게 하여 위치조절하기.

    return (
        <Scoreboard>
            <Turn />
            <ScoreTable />
        </Scoreboard>
    )
}

const Scoreboard = styled.div`
    width:90%;
    height:100px;
    display:flex;
    justify-content:center;
    padding: 20px;
    margin:auto;
    background-color:black;
    border: 1px solid white;
    color:white;
    font-size: 25px;
`;

export default TeamScore