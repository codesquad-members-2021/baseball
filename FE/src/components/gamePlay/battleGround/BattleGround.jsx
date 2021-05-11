import styled from 'styled-components';
import { cssFullAbsolutePosition } from '../../utilComponent/CommonStyledCSS';
import BaseballStadium from './partial/BaseballStadium';
import PitchButton from './partial/PitchButton';
import Round from './partial/Round';
import SBO from './partial/SBO';
import { useState, createContext } from "react";

export const BattleGroundContext = createContext();

const BattleGround = () => {
    const [test, setTest] = useState([0]);
    let arr = test;
    const pitchEvent = () => {
        // setTest(...arr,새로운주자);
        arr = arr.map(v => v+1);
        arr.push(0); // 1 2 // 새로운 주자 출발
        setTest(arr);
    }

    return (
        <BattleGroundContext.Provider value={{test, setTest, arr}}>
            <StyledBattleGround>
                <BaseballStadium/>
                <StadiumPartial>
                    <div className="position__center--all"><PitchButton  onClick={pitchEvent}/></div>
                    <div className="position__right--top"><Round /></div>
                    <div className="position__left--top"><SBO /></div>
                </StadiumPartial>
            </StyledBattleGround>
        </BattleGroundContext.Provider>
    );
};

export default BattleGround;

// --- Styled Components ---
const StyledBattleGround = styled.div`
    height: 100%;
    width: inherit;
    position: relative;
`;

const StadiumPartial = styled.div`
    ${cssFullAbsolutePosition};


    .position__right--top {
        position: absolute;
        top: 0;
        right: 0;
    }

    .position__left--top {
        position: absolute;
        top: 0;
        left: 0;
    }

    .position__center--all {
        position: absolute;
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100%;
        height: 100%;
        /* z-index:-2; */
    }
`;