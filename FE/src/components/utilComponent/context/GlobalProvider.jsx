import { createContext, useState, useMemo } from 'react'

export const GlobalContext = createContext({
    clickLocation: null,
    setClickLocation: () => {}
});

const GlobalProvider = ({children}) => {
    const [clickLocation, setClickLocation] = useState();
    const value = useMemo(() => ({clickLocation, setClickLocation}), [clickLocation, setClickLocation]);
    return(
        <GlobalContext.Provider value={value}>
            {children}
        </GlobalContext.Provider>
    )
}

export default GlobalProvider;