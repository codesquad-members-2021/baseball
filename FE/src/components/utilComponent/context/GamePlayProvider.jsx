import { createContext, useReducer, useMemo } from 'react';

// 1. 현재 게임 진행상황이나 대결 중인 팀 데이터를 관리하는 Reducer
const gamePlayInitialState = {
    teamsData: null,
    gameProgress: {
        homeOrAway: '',
        userTeamName: '',
        opponentTeamName: '',
        attacker: '',

        awayScore: 0,
        homeScore: 0,

        situation: null,
        strikeCount: 0,
        ballCount: 0,
        outCount: 0,

        pitcher: null,
        hitter: null,
    },
};

const gamePlayReducer = (state, action) => {
    const { type, payload, changeType } = action;

    switch (type) {
        case 'setTeamsData':
            return {
                ...state,
                teamsData: payload,
            };
        case 'changeGameProgress': {
            if (!changeType)
                throw new Error(
                    '[Error] dispatch - gamePlay(changeGameProgress)',
                );
            return {
                ...state,
                gameProgress: {
                    ...state.gameProgress,
                    [changeType]: payload,
                },
            };
        }
        case 'manyChangeGameProgress': {
            // 여기에 들어오는 payload는 객체로 전달해주기
            if (!payload)
                throw new Error(
                    '[Error] dispatch - gamePlay(manyChangeGameProgress)',
                );
            return {
                ...state,
                gameProgress: {
                    ...state.gameProgress,
                    ...payload,
                },
            };
        }
        default:
            throw new Error('[Error] dispatch - gamePlay');
    }
};

// 2. GamePlay 컴포넌트의 기타사항들을 관리하는 Reducer
// Popup 등 각종 Flag 등
const gamePlayOptionsInitialState = {
    teamScorePopupVisible: false,
    playListPopupVisible: false,
    ryanIconStatus: null,
};

const gamePlayOptionsReducer = (state, { type, payload }) => {
    switch (type) {
        case 'teamScoreVisibleToggle':
            return {
                ...state,
                teamScorePopupVisible: !state.teamScorePopupVisible,
            };
        case 'playerListVisibleToggle':
            return {
                ...state,
                playListPopupVisible: !state.playListPopupVisible,
            };
        case 'changeRyanIconStatus':
            return {
                ...state,
                ryanIconStatus: payload,
            };
        default:
            throw new Error('[Error] dispatch - gamePlayOptions');
    }
};

export const GamePlayContext = createContext({
    gamePlayState: null,
    gamePlayDispatch: () => {},
    gamePlayOptionsState: null,
    gamePlayOptionsDispatch: () => {},
});

const GamePlayProvider = ({ children }) => {
    const [gamePlayState, gamePlayDispatch] = useReducer(
        gamePlayReducer,
        gamePlayInitialState,
    );
    const [gamePlayOptionsState, gamePlayOptionsDispatch] = useReducer(
        gamePlayOptionsReducer,
        gamePlayOptionsInitialState,
    );

    const value = useMemo(
        () => ({
            gamePlayState,
            gamePlayDispatch,
            gamePlayOptionsState,
            gamePlayOptionsDispatch,
        }),
        [
            gamePlayState,
            gamePlayDispatch,
            gamePlayOptionsState,
            gamePlayOptionsDispatch,
        ],
    );

    return (
        <GamePlayContext.Provider value={value}>
            {children}
        </GamePlayContext.Provider>
    );
};
export default GamePlayProvider;
