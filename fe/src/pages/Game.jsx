import React, { useEffect } from 'react';
import useFetch from 'hooks/useFetch';
import Header from 'components/GamePlay/playHeader/Header'
import qs from 'qs'
// 쿼리값 읽고 데이터 페치 받은다음에 뿌려준다. 
export const gamePlayContext = React.createContext();

const Game = () => {
    
    const {team} = qs.parse(window.location.search, {
        ignoreQueryPrefix: true,
         });

    const {response, loading, error} = useFetch(process.env.REACT_APP_API_URL + `/select-${team}.json`);
    if(loading) return <div>loading</div>
    const [home, away] = response.team_info;

    
    
         
    return (
        <gamePlayContext.Provider value={{home, away}}>
            <Header />
        </gamePlayContext.Provider>
        )
}

export default Game