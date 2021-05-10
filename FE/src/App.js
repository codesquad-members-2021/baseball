import './common/style/reset.css';
import { ThemeProvider } from 'styled-components';
import { Switch, Route } from 'react-router-dom';
import AppStyle, { StyledBackground, StyledMain } from './common/style/AppStyle';
import theme from './common/style/theme';

import IntroPage from './pages/IntroPage';
import GamePlayPage from './pages/GamePlayPage';

const App = () => {
    return (
        <ThemeProvider theme={theme}>
            <AppStyle />
            <StyledBackground />

            <StyledMain>
                <Switch>
                    <Route path={'/'} exact component={IntroPage} />
                    <Route path={'/game/:homeId/VS/:awayId'} exact component={GamePlayPage} />
                    <Route
                        render={() => (
                            <div style={{ color: 'white', fontSize: '80px' }}>
                                404!!!!!
                            </div>
                        )}
                    />
                </Switch>
            </StyledMain>
        </ThemeProvider>
    );
};

export default App;
