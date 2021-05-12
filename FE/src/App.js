import './common/style/reset.css';
import { ThemeProvider } from 'styled-components';
import { Switch, Route } from 'react-router-dom';
import AppStyle from './common/style/AppStyle';
import theme from './common/style/theme';
import IntroPage from './pages/IntroPage';
import GamePlayPage from './pages/GamePlayPage';
import Background from './components/utilComponent/Background';

const App = () => {
    return (
        <ThemeProvider theme={theme}>
            <AppStyle />
            <Background />

            <Switch>
                <Route path={'/'} exact component={IntroPage} />
                <Route path={'/game'} exact component={GamePlayPage} />
                <Route
                    render={() => (
                        <div style={{ color: 'white', fontSize: '80px' }}>
                            404!!!!!
                        </div>
                    )}
                />
            </Switch>
        </ThemeProvider>
    );
};

export default App;
