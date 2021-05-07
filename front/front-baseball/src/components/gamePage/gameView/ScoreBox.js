import React from 'react';
import styled from 'styled-components';

const CenterContainer = styled.div`
display: flex;
align-items: center;
flex-direction:column;
`;

const ScoreCotainer = styled(CenterContainer)`
width:100%;
height: 25%;
border-bottom: 10px solid black;
`;
const GameInfo = styled.div`
margin-top: 50px;
font-size: 30px;
`;
const MatchInfo = styled.div`
padding: 20px;
font-size: 50px;
`;
const ScoreBox = () => {
    return (
        <ScoreCotainer>
            <GameInfo>BASEBALL GAME ONLINE</GameInfo>
            <MatchInfo>Captain 1 vs 5 Marvel</MatchInfo>
        </ScoreCotainer>
    );
}

export default ScoreBox;
