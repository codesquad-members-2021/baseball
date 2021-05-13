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
        const { 
            gameProgress: { 
                situation, ballCount, strikeCount, outCount, 
                userTeamName,
                userPlayers, opponentPlayers,
                userHitterIdx, opponentHitterIdx,
                attackerTeamName,
            } 
        } = gamePlayState;

        const { ryanIconStatus } = gamePlayOptionsState;

        if (!ryanIconStatus || !situation) return;

        let isOut = false;
        let isFourBall = false;

        if (situation === 'STRIKE') {
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
            } else return;
        } else if (situation === 'BALL') {
            let nextBallCount = ballCount + 1;

            if (nextBallCount > 3) {
                nextBallCount = 0;
                isFourBall = true;
            }

            gamePlayDispatch({
                type: 'changeGameProgress',
                changeType: 'ballCount',
                payload: nextBallCount,
            });

            if (!isFourBall) return;
        }

        const nextOpponentHitterIdx =
            (opponentHitterIdx + 1 === opponentPlayers.length)
                ? 1
                : opponentHitterIdx + 1;

        const nextUserHitterIdx = 
            (userHitterIdx + 1 === userPlayers.length)
                ? 1
                : userHitterIdx + 1

        gamePlayDispatch({
            type: 'manyChangeGameProgress',
            payload: {
                ballCount: 0,
                strikeCount: 0,
                userHitterIdx: (userTeamName === attackerTeamName)
                    ? nextUserHitterIdx
                    : userHitterIdx,
                opponentHitterIdx: (userTeamName === attackerTeamName)
                    ? opponentHitterIdx
                    : nextOpponentHitterIdx,
                hitter: (userTeamName === attackerTeamName)
                    ? userPlayers[nextUserHitterIdx]
                    : opponentPlayers[nextOpponentHitterIdx]
            },
        });
        if (isOut) return;


        // 라이언 움직여!!!
        const currRyanIconStatus = ryanIconStatus
            .map((v) => {
                const nextIdx = (v[0] + 1);
                const currUuid = v[1];
                if (nextIdx === 4) {
                    // 3루에서 홈으로 들어갈때.. (지금은 무조건 +1)
                    const { gameProgress: { awayScore, homeScore, attacker } } = gamePlayState;

                    gamePlayDispatch({
                        type: 'changeGameProgress',
                        changeType: (attacker === 'away') ? 'awayScore' : 'homeScore',
                        payload: (attacker === 'away') ? awayScore + 1 : homeScore + 1,
                    });
                }
                return [nextIdx, currUuid];
            })
            .concat([[0, uuid()]])
            .slice(-5);

        gamePlayOptionsDispatch({
            type: 'changeRyanIconStatus',
            payload: currRyanIconStatus,
        });
        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [gamePlayState.gameProgress.situation]);

    // 3) 3아웃 시 공수교대
    useEffect(() => {
        const {
            teamsData,
            gameProgress: { attacker, attackerTeamName, outCount, attackOrDefense, roundState },
        } = gamePlayState;

        if (outCount < 3) return;
        const {
            user: { players: userPlayers, team_name: userTeamName },
            opponent: { players: opponentPlayers, team_name: opponentTeamName  },
        } = teamsData;

        gamePlayDispatch({
            type: 'manyChangeGameProgress',
            payload: {
                outCount: 0,
                attacker: (attacker === 'away') ? 'home' : 'away',
                attackerTeamName: (attackerTeamName === userTeamName) ? opponentTeamName : userTeamName,
                attackOrDefense: attackOrDefense === 'attack' ? 'defense' : 'attack',
                roundState: attackOrDefense === 'attack' ? roundState : roundState + 1,
                pitcher: (attackerTeamName === userTeamName) ? userPlayers[0] : opponentPlayers[0],
                hitter: (attackerTeamName === userTeamName) ? opponentPlayers[1] : userPlayers[1],
            },
        });

        gamePlayOptionsDispatch({
            type: 'changeRyanIconStatus',
            payload: [[0, uuid()]],
        });

        // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [gamePlayState.gameProgress.outCount]);


    // 4) Pitch 클릭이 되면, gamePlayState.gameProgress.situation 초기화
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
        const arrStrike = [...Array(5)].map((_) => "STRIKE");
        const arrBall = [...Array(5)].map((_) => "BALL");
        const arrHits = [...Array(1)].map((_) => "HITS");

        let kind = [...arrStrike, ...arrBall, ...arrHits];
        let randomNumber = Math.floor(Math.random() * kind.length);
        return kind[randomNumber];
    };

    const pitchEvent = () => {
        const situation = randomSituation();
        console.log(situation)
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
