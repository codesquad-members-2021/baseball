import styled from 'styled-components';
import * as CS from '@/Styles/CommonStyles';
import theme from '@/Styles/theme';

const IntroStyles = {
  Intro: styled(CS.BOX.FLEX_CENTER_BOX)`
    background: #222;
    width: 1440px;
    height: 1080px;
    color: ${theme.COLOR.DEFAULT};
  `,

  GameTitle: styled.div`
    text-align: center;
  `,

  GameStartButton: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 650px;
    height: 100px;
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
};

export { IntroStyles };
