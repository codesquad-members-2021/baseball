import styled from 'styled-components';
import { cssFullAbsolutePosition } from '../../utilComponent/CommonStyledCSS';
import BaseballStadium from './partial/BaseballStadium';
import PitchButton from './partial/PitchButton';
import Round from './partial/Round';
import SBO from './partial/SBO';
import { useState, useContext, useEffect } from 'react';
import { uuid } from 'uuidv4';
import { GamePlayContext } from '../../utilComponent/context/GamePlayProvider';

// export const BattleGroundContext = createContext();

const BattleGround = () => {
    const [isPitchClick, setIsPitchClick] = useState(false);
    const {
        gamePlayState,
        gamePlayDispatch,
        gamePlayOptionsState,
        gamePlayOptionsDispatch,
    } = useContext(GamePlayContext);

    // [1] useEffect
    // 1) 초기 렌더링
    useEffect(
        () =>
            gamePlayOptionsDispatch({
                type: 'changeRyanIconStatus',
                payload: [[0, uuid()]],
            }),
        // eslint-disable-next-line react-hooks/exhaustive-deps
        [],
    );

    // 2) gamePlayState.gameProgress.situation 변경 시
    useEffect(() => {
        const { gameProgress: { situation, ballCount, strikeCount, outCount } } = gamePlayState;
        const { ryanIconStatus } = gamePlayOptionsState;

        if (!ryanIconStatus || !situation) return;

        if (situation === 'STRIKE') {
            let isOut = false;
            let nextStrikeCount = strikeCount + 1;

            if (nextStrikeCount > 2) {
                nextStrikeCount = 0;
                isOut = true;
            }

            gamePlayDispatch({
                type: 'changeGameProgress',
                changeType: 'strikeCount',
                payload: nextStrikeCount,
            });

            if (isOut) {
                let nextOutCount = outCount + 1;
                gamePlayDispatch({
                    type: 'changeGameProgress',
                    changeType: 'outCount',
                    payload: nextOutCount,
                });
            }
            return;
        } else if (situation === 'BALL') {
            let isHits = false;
            let nextBallCount = ballCount + 1;

            if (nextBallCount > 3) {
                nextBallCount = 0;
                isHits = true;
            }

            gamePlayDispatch({
                type: 'changeGameProgress',
                changeType: 'ballCount',
                payload: nextBallCount,
            });

            if (!isHits) return;
        } else {
            gamePlayDispatch({
                type: 'manyChangeGameProgress',
                changeType: 'ballCount',
                payload: {
                    ballCount: 0,
                    strikeCount: 0
                },
            });
        }

        // 라이언 움직여!!!
        const currRyanIconStatus = ryanIconStatus
            .map((v) => [v[0] + 1, v[1]])
            .concat([[0, uuid()]])
            .slice(-5);

        gamePlayOptionsDispatch({
            type: 'changeRyanIconStatus',
            payload: currRyanIconStatus,
        });
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [gamePlayState.gameProgress.situation]);


    // 3) Pitch 클릭이 되면, gamePlayState.gameProgress.situation 초기화
    useEffect(() => {
        if (!isPitchClick) return;
        gamePlayDispatch({
            type: 'changeGameProgress',
            changeType: 'situation',
            payload: null,
        });
        setIsPitchClick(false);
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [isPitchClick]);


    // [2] event 관련
    const randomSituation = () => {
        let kind = ['HITS', 'BALL', 'STRIKE'];
        let randomNumber = Math.floor(Math.random() * kind.length);
        return kind[randomNumber];
    };

    const pitchEvent = () => {
        const situation = randomSituation();

        gamePlayDispatch({
            type: 'changeGameProgress',
            changeType: 'situation',
            payload: situation,
        });
        setIsPitchClick(true);
    };

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
