import React from 'react';
import styled from 'styled-components';
import GroundBox from "./GroundBox";
import ScoreBox from "./ScoreBox";
import PlayerBox from "./PlayerBox";
import PlayerDetailBox from "./PlayerDetailBox"
const GameContainer = styled.div`

position: absolute;
width:100%;
height:100%;
border: 10px solid black;
`;
const MatchContainer = styled.div`
float: left;
width: 75%;
height: 100%;
border-right: 10px solid black;
`;
const PlayerContainer = styled.div`
float: right;
width: 25%;
height: 100%;
`;


const GameMainBox = () => {
    return (
        <GameContainer>
            <MatchContainer>
                <ScoreBox />
                <GroundBox />
            </MatchContainer>
            <PlayerContainer>
                <PlayerBox />
                <PlayerDetailBox />
            </PlayerContainer>
        </GameContainer>
    );
}

export default GameMainBox;
