import React, { useState } from 'react';
import Title from 'components/common/Title';
import styled from 'styled-components';
import GameLists from 'components/GameHome/GameLists';
import useFetch from 'hooks/useFetch';

export const GameContext = React.createContext();

const GameContainer = () => {
  const { response, loading, error } = useFetch(process.env.REACT_APP_API_HOME);

  const [toggle, setToggle] = useState(false);
  const changeNotice = () => setToggle(true);

  if (error) return console.error(error);
  return (
    <GameContext.Provider value={{ changeNotice }}>
      <GameSection>
        <Title size={'L'}>BASEBALL GAME ONLINE</Title>
        <GameNotice>
          {toggle
            ? '이미 진행중인 게임입니다! ㅡㅡ'
            : '참가할 게임을 선택하세요.'}
        </GameNotice>
        {!loading && <GameLists data={response} />}
      </GameSection>
    </GameContext.Provider>
  );
};

export default GameContainer;
const GameSection = styled.section`
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
`;
const GameNotice = styled.span`
  color: #fff;
  font-size: 2rem;
  margin: 2rem 0;
`;
