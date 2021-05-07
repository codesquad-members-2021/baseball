import styled from 'styled-components';
import * as CS from '@/Styles/CommonStyles';
import theme from '@/Styles/theme';

const HomeStyles = {
  Home: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)`
    width: 1440px;
    height: 1080px;
    color: ${theme.COLOR.DEFAULT};
    border: 3px solid #fff;
    background: #111;
    opacity: 0.8;
    padding-top: 40px;
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

  HomeTitle: styled.div`
    font-size: 36px;
    font-weight: 700;
    padding: 20px;
    margin-bottom: 10px;
  `,

  MatchInfo: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)`
    width: 500px;
  `,

  MatchInfoTitle: styled.div`
    padding: 40px 40px 20px 40px;
    font-size: 24px;
    letter-spacing: 3px;
  `,
  MatchInfoBody: styled.div`
    width: 100%;
    height: 340px;
    padding: 0px 20px 0px 10px;
    overflow-y: scroll;

    ::-webkit-scrollbar {
      width: 10px;
      height: 20px;
    }

    ::-webkit-scrollbar-track {
      background-color: #222;
      border-radius: 8px;
    }

    ::-webkit-scrollbar-thumb {
      border-radius: 8px;
      background: #ffd2e1;
    }

    mask-image: linear-gradient(to top, transparent, #222),
      linear-gradient(to left, transparent 12px, #222 12px);
    mask-size: 100% 2000000px;
    mask-position: left bottom;
    transition: mask-position 0.3s, -webkit-mask-position 0.3s;

    :hover {
      mask-position: left top;
    }
  `,

  ScrollMask: styled.div`
    width: 100%;
    border: 1px solid #ffa7c4;
  `,

  MatchBox: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)`
    border: 1px solid #fff;
    border-radius: 10px;
    margin: 10px;
    width: 100%;
    height: 100px;
    justify-content: center;
  `,

  GameNumber: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 100%;
    height: 50%;
    padding: 15px 10px 0px 10px;
    font-size: 12px;
    color: #ffa7c4;
  `,

  Match: styled.div`
    display: flex;
    align-items: center;
    width: 100%;
    height: 100%;
    padding: 0px 5px 5px 5px;
    justify-content: space-evenly;
  `,

  TeamName: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 100%;
    height: 100%;
    display: flex;
    justify-content: center;
    align-items: center;
    font-size: 23px;
    font-weight: 900;
    cursor: pointer;
    transition: all ease-in-out 0.2s;

    :hover {
      color: #ffa7c4;
      font-size: 24px;
    }
  `,

  VS: styled.div`
    display: flex;
    align-items: center;
    font-weight: 900;
    font-size: 14px;
  `,
};

export { HomeStyles };
