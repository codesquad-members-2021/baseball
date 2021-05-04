import IntroStyles from '@/Components/Intro/IntroStyles';

import styled from 'styled-components';

const IntroLogo = () => {
  return (
    <a href="/home">
      <IntroLogoBox>
        <LogoTitle>
          Team illy's Baseball game! <br />
          comming soon...
        </LogoTitle>
      </IntroLogoBox>
    </a>
  );
};

const Intro = () => {
  return (
    <IntroStyles>
      <IntroLogo />
    </IntroStyles>
  );
};

export default Intro;

const IntroLogoBox = styled.div`
  width: 600px;
  height: 80px;
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 10px;
  display: flex;
  align-items: center;
  justify-content: center;
  cursor: pointer;
  font-size: 30px;
  transition: all ease-in-out 0.4s;
  font-weight: 700;

  :hover {
    background: #333;
  }
  :active {
    background: #111;
  }
`;

const LogoTitle = styled.div`
  text-align: center;
`;
