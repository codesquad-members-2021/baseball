import './common/style/reset.css';
import { ThemeProvider } from 'styled-components';
import GlobalStyle from './common/style/GlobalStyle';
import theme from './common/style/theme';
import TeamSelect from './components/teamSelect/TeamSelect';
import GamePlay from './components/gamePlay/GamePlay';

const App = () => {
    return (
        <ThemeProvider theme={theme}>
            <GlobalStyle />
            <TeamSelect />
            {/* <GamePlay /> */}
        </ThemeProvider>
    );
};

export default App;
