import styled from 'styled-components';
import { cssFullAbsolutePosition } from '../../utilComponent/CommonStyledCSS';
import BaseballStadium from './partial/BaseballStadium';
import PitchButton from './partial/PitchButton';
import Round from './partial/Round';
import SBO from './partial/SBO';
import { useContext, useEffect } from 'react';
import { uuid } from 'uuidv4';
import { GamePlayContext } from '../../utilComponent/context/GamePlayProvider';

// export const BattleGroundContext = createContext();

const BattleGround = () => {
    const { gamePlayOptionsState, gamePlayOptionsDispatch } = useContext(GamePlayContext);
    // const [test, setTest] = useState([ [ 0, uuid() ] ]);

    useEffect(
        () =>
            gamePlayOptionsDispatch({
                type: 'changeRyanIconStatus',
                payload: [[0, uuid()]],
            }),
        // eslint-disable-next-line react-hooks/exhaustive-deps
        [],
    );

    const pitchEvent = () => {
        const { ryanIconStatus } = gamePlayOptionsState;
        if (!ryanIconStatus) return;

        const currRyanIconStatus = 
            ryanIconStatus
                .map((v) => [v[0] + 1, v[1]])
                .concat([[0, uuid()]])
                .slice(-5);

        gamePlayOptionsDispatch({
            type: 'changeRyanIconStatus',
            payload: currRyanIconStatus
        });
    }

    // const pitchEvent = () => {
        // setTest(() =>
        //     test
        //         .map((v) => [v[0] + 1, v[1]])
        //         .concat([[0, uuid()]])
        //         .slice(-5),
        // );
    // };

    return (
        <StyledBattleGround>
            <StadiumPartial>
                <div className="position__center--all">
                    <BaseballStadium />
                    <PitchButton onClick={pitchEvent} />
                </div>
                <div className="position__right--top">
                    <Round />
                </div>
                <div className="position__left--top">
                    <SBO />
                </div>
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
        /* z-index:-2; */
    }
`;
