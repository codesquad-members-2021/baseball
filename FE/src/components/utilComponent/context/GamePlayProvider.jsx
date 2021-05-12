import { createContext, useReducer, useMemo } from 'react';

const gamePlayInitialState = {
    teamScorePopupVisible: false,
    playListPopupVisible: false,
};

const gamePlayReducer = (state, action) => {
    switch (action.type) {
        case 'teamScoreVisibleControl':
            return {
                ...state,
                teamScorePopupVisible: !state.teamScorePopupVisible,
            };
        case 'playerListVisibleControl':
            return {
                ...state,
                playListPopupVisible: !state.playListPopupVisible,
            };
        default:
            throw new Error();
    }
};

export const GamePlayContext = createContext({
    gamePlayState: null,
    gamePlayDispatch: () => {},
});

const GamePlayProvider = ({ children }) => {
    const [gamePlayState, gamePlayDispatch] = useReducer(gamePlayReducer, gamePlayInitialState);

    const value = useMemo(() => ({ gamePlayState, gamePlayDispatch }), [gamePlayState, gamePlayDispatch]);

    return (
        <GamePlayContext.Provider value={value}>
            {children}
        </GamePlayContext.Provider>
    );
};
export default GamePlayProvider;