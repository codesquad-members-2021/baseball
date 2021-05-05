import { useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import styled from 'styled-components';
import { GoogleLogin } from 'react-google-login';

const Home = () => {
  const [isLogin, setIsLogin] = useState(false);

  const handleLoginClick = () => setIsLogin(true);
  return (
    <StyledHome>
      this is home.
      <button>
        <Link to='/intro'>팀 선택하기</Link>
      </button>
      <GoogleLogin
        clientId='869491322305-t4abjiphkaprn12snvpsqqi1bf8bb3be.apps.googleusercontent.com'
        onSuccess={responseGoogle}
        onFailure={responseGoogle}
      />
    </StyledHome>
  );
};

export default Home;

const responseGoogle = (response) => {
  console.log(response);
};

const StyledHome = styled.div``;
