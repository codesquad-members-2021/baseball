import styled, { createGlobalStyle, css } from 'styled-components';

const cssFullSize = css`
    height: inherit;
    width: initial;

    position: absolute;
    top: 0;
    bottom: 0;
    left: 0;
    right: 0;
`;

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

export const StyledMain = styled.div`
    ${cssFullSize};
    display: flex;
    justify-content: center;
    align-items: center;
    z-index: 10;
`;

export const StyledBackground = styled.div`
    ${cssFullSize};
    z-index: 0;
    background-color: ${({ theme }) => theme.colors.black1};
    opacity: 0.7;
`;

export default AppStyle;
