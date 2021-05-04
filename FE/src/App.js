import './common/style/reset.css';
import { ThemeProvider } from 'styled-components';
import GlobalStyle from './common/style/GlobalStyle';
import theme from './common/style/theme';
import TeamSelect from './components/teamSelect/TeamSelect';

const App = () => {
    return (
        <ThemeProvider theme={theme}>
            <GlobalStyle />
            <TeamSelect />
        </ThemeProvider>
    );
};

export default App;
