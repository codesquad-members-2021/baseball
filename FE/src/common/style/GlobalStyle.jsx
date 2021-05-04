import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
    body {
        width: 1440px;
        height: 100vh;
        margin: 0 auto;
        background-color: ${({ theme }) => theme.colors.black};
    }

    #root {
        height: 100%;
    }
`;

export default GlobalStyle;