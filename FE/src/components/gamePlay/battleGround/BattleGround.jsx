import styled from 'styled-components';
import BaseballStadium from './partial/BaseballStadium';
import PitchButton from './partial/PitchButton';
import Round from './partial/Round';
import SBO from './partial/SBO';

const BattleGround = () => {
    return (
        <StyledBattleGround>
            <BaseballStadium />
            <StadiumPartial>
                <div className="position__center--all"><PitchButton /></div>
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
    position: absolute;
    top: 0;
    left: 0;
    bottom: 0;
    right: 0;


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