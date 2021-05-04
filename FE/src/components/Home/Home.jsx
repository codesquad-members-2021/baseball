import { useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import styled from 'styled-components';

const Home = () => {
  const [isLogin, setIsLogin] = useState(false);

  const handleLoginClick = () => setIsLogin(true);
  return (
    <StyledHome>
      this is home.
      <button>
        <Link to="/intro">팀 선택하기</Link>
      </button>
      <button onClick={handleLoginClick}>로그인</button>
    </StyledHome>
  );
};

export default Home;

const StyledHome = styled.div``;
