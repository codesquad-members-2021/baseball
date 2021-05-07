import styled from 'styled-components';

const Title = () => <TitleDiv>BASEBALL GAME ONLINE</TitleDiv>;

const TitleDiv = styled.div`
  font-size: ${({ theme }) => theme.fontSizes.XL};
`;

export default Title;
