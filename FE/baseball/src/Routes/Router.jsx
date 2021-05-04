import Home from '@/Components/Home/Home';
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import { Inrto } from '@/Routes/Intro';

const Router = () => {
  return (
    <BrowserRouter>
      <Route exact path="/" component={Inrto} />
      <Switch>
        <Route path="/home" component={Home} />
        {/* <Route path="/game" component={Game} /> */}
      </Switch>
    </BrowserRouter>
  );
};

export default Router;
