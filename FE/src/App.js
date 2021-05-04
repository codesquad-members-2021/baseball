import './style/reset.css';
import { createGlobalStyle } from 'styled-components';
import TeamSelect from './components/teamSelect/TeamSelect';

const GlobalStyle = createGlobalStyle`
    body {
        width: 1440px;
        margin: 0 auto;
    }
`;

const App = () => {
    return (
        <>
            <GlobalStyle />
            <TeamSelect />
        </>
    );
};

export default App;
