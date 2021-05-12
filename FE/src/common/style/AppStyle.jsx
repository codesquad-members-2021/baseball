import { createGlobalStyle } from 'styled-components';

const AppStyle = createGlobalStyle`
    body {
        height: 100vh;
        width: 100%;
    }

    #root {
        height: inherit;
        background-image: url('/images/background.jpg');
        background-repeat: no-repeat;
        background-size: cover;
    }
`;

export default AppStyle;