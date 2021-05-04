import { useState } from 'react';
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

const Home = () => {
  const [isLogin, setIsLogin] = useState(false);

  const handleLoginClick = () => setIsLogin(true);
  return (
    <>
      <div>
        this is home.
        <button>
          <Link to="/intro">팀 선택하기</Link>
        </button>
      </div>
      <button onClick={handleLoginClick}>로그인</button>
    </>
  );
};

export default Home;
