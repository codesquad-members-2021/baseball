import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

const InGame = () => {
  return (
    <>
      this is ingame.
      <button>
        <Link to="/">메인으로</Link>
      </button>
    </>
  );
};

export default InGame;
