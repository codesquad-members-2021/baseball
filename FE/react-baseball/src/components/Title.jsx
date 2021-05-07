import styled from 'styled-components';

const Title = ({ type }) => (
  <TitleDiv type={type}>BASEBALL GAME ONLINE</TitleDiv>
);

const TitleDiv = styled.div`
  margin: 18px 0;
  font-size: ${({ theme, type }) =>
    type === theme.screenType.PLAY ? theme.fontSizes.S : theme.fontSizes.XXL};
  font-weight: 600;
`;

export default Title;
