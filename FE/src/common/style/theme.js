// styled-components의 ThemeProvider에 쓰임
// ThemeProvider는 useContext 쓰듯 사용하기!

const fontFamily = 'Noto Sans KR';
const fontWeight = {
    normal: 400,
    bold: 700,
    bold2: 900,
};
const fontSize = {
    XS: '18px',
    S: '24px',
    M: '30px',
    L: '36px',
    XL: '42px',
    XXL: '48px',
    XXXL: '54px',
    XXXXL: '60px',
    TEAM: '74px'
};
const colors = {
    white: '#FFF',
    red: '#CC484D',
    black: '#010101',
    gray1: '#333',
    gray2: '#4F4F4F',
    gray3: '#828282',
    gray4: '#BDBDBD',
    gray5: '#E0E0E0',
    gray6: '#F5F5F7',
    mint: '#1EBFD4',
};

const theme = {
    fontFamily,
    fontWeight,
    fontSize,
    colors
};
export default theme;
