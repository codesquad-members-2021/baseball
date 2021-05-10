import { useState, createContext } from "react";
import { BrowserRouter as Router, Switch, Route, Link } from "react-router-dom";
import styled from "styled-components";
import { githubProvider, googleProvider } from "../../config/authProvider";
import socialMediaAuth from "../../service/auth";
import Intro from "../Intro/Intro";
import InGame from "../InGame/InGame";
import NoMatch from "../NoMatch/NoMatch";

export const LoginContext = createContext();

const Home = () => {
  const [loginStatus, setLoginStatus] = useState(false);
  const [userId, setUserId] = useState();
  const [startButtonClick, setStartButtonClick] = useState(false);

  const handleStart = () => {
    setStartButtonClick(true);
  };

  const handleOnClick = async (provider) => {
    const res = await socialMediaAuth(provider);
    if (res.email) {
      setLoginStatus(true);
      const id = getOnlyId(res.email);
      setUserId(id);
    }
  };

  const getOnlyId = (email) => {
    const arr = email.split("@");
    return arr[0];
  };

  return (
    <Router>
      <LoginContext.Provider value={{ loginStatus, userId }}>
        {startButtonClick ? (
          <Switch>
            <Route path="/intro">
              <Intro />
            </Route>
            <Route path="/ingame">
              <InGame />
            </Route>
            <Route path="*">
              <NoMatch />
            </Route>
          </Switch>
        ) : (
          <Wrapper>
            <StyledHome loginStatus={loginStatus}>
              <Title>
                BASEBALL ONLINE <Authors>Freddie, Goody, Seong</Authors>
              </Title>
              {loginStatus ? (
                <UserInfo>{userId}</UserInfo>
              ) : (
                <LoginRequire>
                  게임을 플레이 하려면 로그인해야 합니다.
                </LoginRequire>
              )}
              <SelectTeam login={loginStatus} onClick={handleStart}>
                <Link to="/intro">게임 시작하기</Link>
              </SelectTeam>
              <Login>
                {loginStatus ? (
                  <></>
                ) : (
                  <>
                    <div>소셜 계정으로 로그인</div>
                    <LoginBtns>
                      <button
                        className="github"
                        onClick={() => handleOnClick(githubProvider)}
                      ></button>
                      <button
                        className="google"
                        onClick={() => handleOnClick(googleProvider)}
                      ></button>
                    </LoginBtns>
                  </>
                )}
              </Login>
            </StyledHome>
          </Wrapper>
        )}
      </LoginContext.Provider>
    </Router>
  );
};

export default Home;

const Wrapper = styled.div`
  display: flex;
  justify-content: center;
  align-items: center;
`;

const StyledHome = styled.div`
  display: grid;
  height: 720px;
  grid-template-rows: ${(props) => props.loginStatus && "1fr 0.1fr 1fr 0.5fr"};
`;

const SelectTeam = styled.button`
  display: ${(props) => props.login || "none"};
  width: 50%;
  height: 50%;
  font-size: 30px;
  padding: 0;
  justify-self: center;
  justify-content: center;
  align-items: center;
`;

const LoginRequire = styled.div`
  font-size: 26px;
  color: white;
  text-align: center;
`;

const UserInfo = styled.div`
  color: white;
  justify-self: center;
  justify-content: center;
  align-items: center;
  &::before {
    content: "어서오세요! ";
  }
  height: auto;
`;

const Title = styled.div`
  font-size: 72px;
  color: white;
  margin: 5rem 0;
`;

const Authors = styled.div`
  padding: 0.5rem 0;
  font-size: 20px;
  color: white;
  text-align: end;
  &::before {
    content: "by ";
  }
`;

const Login = styled.div`
  color: white;
  display: flex;
  flex-direction: column;
  justify-content: space-evenly;
  align-items: center;
  font-size: 24px;
`;

const LoginBtns = styled.div`
  display: flex;
  justify-content: space-between;
  width: 25%;

  button {
    width: 55px;
    height: 55px;
    border-radius: 50%;
    border-style: none;
  }

  .github {
    background: url("image/Github-Logo.png") no-repeat;
    background-color: white;
    background-position: 0px -0.6px;
  }

  .google {
    background: url("image/Google-Logo.png") no-repeat;
  }
`;
