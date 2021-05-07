import styled from 'styled-components';
import theme from '../theme';

const Title = () => <TitleDiv theme={theme}>BASEBALL GAME ONLINE</TitleDiv>;

const TitleDiv = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XL};
`;

export default Title;
