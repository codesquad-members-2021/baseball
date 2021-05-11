import styled from 'styled-components';
import { cssFullAbsolutePosition } from '../../utilComponent/CommonStyledCSS';
import BaseballStadium from './partial/BaseballStadium';
import PitchButton from './partial/PitchButton';
import Round from './partial/Round';
import SBO from './partial/SBO';
import { useState } from "react";

const BattleGround = () => {

    const pitchEvent = () => {
        
    }

    return (
        <StyledBattleGround>
            <BaseballStadium />
            <StadiumPartial>
                <div className="position__center--all"><PitchButton onClick={pitchEvent}/></div>
                <div className="position__right--top"><Round /></div>
                <div className="position__left--top"><SBO /></div>
            </StadiumPartial>
        </StyledBattleGround>
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
    }
`;