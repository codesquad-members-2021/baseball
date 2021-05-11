import { useState, useContext } from 'react'
import styled from "styled-components";
import { BattleGroundContext } from "../BattleGround";

const Icon = () => {
    const { test } = useContext(BattleGroundContext);
    
    return (
        <StadiumPlayer>
            {test.map((v,i) => {
                    return <Player key={i} Player={v}/>
                })
            }
        </StadiumPlayer>
    )
}

export default Icon;

const StadiumPlayer = styled.div`
    width:100%;
    height:inherit;
`;

const PlayerLocation = [
    {Player: 0, left: `40%`, top: `80%`},
    {Player: 1, left: `84%`, top: `38%`},
    {Player: 2, left: `40%`, top: `-5%`},
    {Player: 3, left: `-3%`, top: `38%`},
    {Player: 4, left: `40%`, top: `80%`},  // home으로 들어오는 번호
]

const Player = styled.div.attrs(({Player}) => ({
    style: PlayerLocation[Player],
}))`
    visibility: ${({Player}) => Player % 4 === 0 || Player > 4 ? "hidden" : "visible"};
    z-index:8;
    position:absolute;
    width:100px;
    height:100px;
    background-image:url("/images/라이언.gif");
    background-size:contain;
    transition: all 1s ease-in-out;
`;
