import { createGlobalStyle } from 'styled-components';

const GlobalStyle = createGlobalStyle`
    body {
        height: 100vh;
        width: 1440px;
        margin: 0 auto;
        background-color: ${({ theme }) => theme.colors.black};
    }

    #root {
        height: inherit;
        display: flex;
        justify-content: center;
        align-items: center;
    }
`;

export default GlobalStyle;