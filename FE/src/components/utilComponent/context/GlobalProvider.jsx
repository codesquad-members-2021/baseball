import { createContext, useReducer, useMemo } from 'react';

const globalInitialState = {
    clickLocation: "",
    loginModalVisible: false,
};

const globalReducer = (state, action) => {
    const { type, payload } = action;

    switch (type) {
        case 'clickLocationChange':
            return {
                ...state,
                clickLocation: payload,
            };
        case 'loginModalVisibleControl':
            return {
                ...state,
                loginModalVisible: !state.loginModalVisible,
            };
        default:    throw new Error();
    }
};

export const GlobalContext = createContext({
    globalState: null,
    globalDispatch: () => {},
});

const GlobalProvider = ({ children }) => {
    const [globalState, globalDispatch] = useReducer(globalReducer, globalInitialState);
    const value = useMemo(() => ({ globalState, globalDispatch }), [globalState, globalDispatch]);
    return (
        <GlobalContext.Provider value={value}>
            {children}
        </GlobalContext.Provider>
    );
};

export default GlobalProvider;
