import React, {useState} from 'react';
import GameTitle from 'components/GameHome/GameTitle';
import styled from 'styled-components';
import GameLists from 'components/GameHome/GameLists';
import useFetch from 'hooks/useFetch';

export const GameContext = React.createContext()

const GameContainer = () => {
  const { response, loading, error } = useFetch(
    process.env.REACT_APP_API_URL + '/data.json'
  )

  const [toggle, setToggle] = useState(false);
  const changeNotice = () => setToggle(true);
  
  
  return (
    <GameContext.Provider value={{changeNotice}}>
    <GameSection>
      <GameTitle size={'L'}>BASEBALL GAME ONLINE</GameTitle>
      <GameNotice>{toggle ? '이미 진행중인 게임입니다! ㅡㅡ':'참가할 게임을 선택하세요.'}</GameNotice>
      {!loading && (
          <GameLists data={response.game_list}/>
      )}
    </GameSection>
     </GameContext.Provider>
  )
}

export default GameContainer
const GameSection = styled.section`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`
const GameNotice = styled.span`
  color: #fff;
  font-size: 2rem;
  margin: 2rem 0;
`
