import { BrowserRouter, Redirect, Route, Switch } from 'react-router-dom';
import { Inrto } from '@/Routes/Intro';
import { Home } from '@/Routes/Home';

const Router = () => {
  return (
    <BrowserRouter>
      <Route exact path="/" component={Inrto} />
      <Switch>
        <Route path="/home" component={Home} />
        {/* <Route path="/game" component={Game} /> */}
        <Redirect from="*" to="/" />
      </Switch>
    </BrowserRouter>
  );
};

export default Router;
