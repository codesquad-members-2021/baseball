import styled from 'styled-components';
import * as CS from '@/Styles/CommonStyles';
import theme from '@/Styles/theme';

const IntroStyles = {
  Intro: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 1440px;
    height: 1080px;
    color: ${theme.COLOR.DEFAULT};
    border: 3px solid #fff;
    background: #111;
    opacity: 0.8;
  `,

  GameTitle: styled.div`
    width: 100%;
    font-size: 50px;
    font-weight: 900;
    text-align: center;
  `,

  GameStartButton: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 1000px;
    height: fit-content;
    padding: 20px;
    border: 1px solid #fff;
    border-radius: 10px;
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
  `,

  Background: styled.img`
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: -999;
    opacity: 0.4;
  `,
};

export { IntroStyles };
