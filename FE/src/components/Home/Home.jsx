import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import styled from 'styled-components';
import { githubProvider, googleProvider } from '../../config/authMethods';
import socialMediaAuth from '../../service/auth';

const handleOnClick = async (provider) => {
  const res = await socialMediaAuth(provider);
  console.log(res);
};
const Home = () => {
  return (
    <StyledHome>
      this is home.
      <button>
        <Link to="/intro">팀 선택하기</Link>
      </button>
      <button onClick={() => handleOnClick(githubProvider)}>github</button>
      <button onClick={() => handleOnClick(googleProvider)}>google</button>
    </StyledHome>
  );
};

export default Home;

const StyledHome = styled.div``;
