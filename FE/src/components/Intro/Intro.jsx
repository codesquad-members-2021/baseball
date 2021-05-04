import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

const Intro = () => {
  return (
    <>
      <div>here is intro</div>
      <button>
        <Link to="/ingame">인게임 입장</Link>
      </button>
      <button>
        <Link to="/">메인으로</Link>
      </button>
    </>
  );
};

export default Intro;
