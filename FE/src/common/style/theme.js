// styled-components의 ThemeProvider에 쓰임
// ThemeProvider는 useContext 쓰듯 사용하기!
const fontFamily = 'Noto Sans KR';
const fontWeight = {
    normal: 400,
    bold: 700,
    bold2: 900,
};
const fontSize = {
    XS: '16px',
    S: '20px',
    M: '24px',
    L: '28px',
    XL: '32px',
    XXL: '36px',
    XXXL: '42px',
    XXXXL: '48px',
    TEAM: '54px'
};
const colors = {
    white: '#FFF',
    red: '#CC484D',
    yellow: '#FAF300',
    green: '#00EA00',
    black1: '#010101',
    black2: '#181818',
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
