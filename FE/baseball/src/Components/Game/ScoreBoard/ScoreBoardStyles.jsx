import styled, { keyframes } from 'styled-components';
import * as CS from '@/Styles/CommonStyles';
import { BLOCK, NONE } from '@/Utils/const';
import theme from '@/Styles/theme';

const ArrowFade = keyframes`
0% {
  top: 0px;
  opacity: 0;
}
50% {
  top: 2px;
}
100% {
  top: 4px;
}
`;

const ScoreBoardStyles = {
  ScoreBoard: styled(CS.BOX.FLEX_CENTER_BOX)`
    position: absolute;
    top: ${({ scoreBoardPosition }) => `${scoreBoardPosition}px`};
    left: 220px;
    width: 1000px;
    font-weight: 900;
    font-size: 24px;
    padding: 10px 40px;
    border: 1px solid #fff;
    background: #111;
    transition: all ease-in-out 0.8s;
    cursor: pointer;
    z-index: 20;
  `,

  ScoreTable: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)``,

  ScoreRow: styled(CS.BOX.FLEX_CENTER_BOX)``,

  ScoreRowHead: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 100%;
    margin-top: 10px;
  `,
  ScoreMiddleLine: styled.div`
    width: 100%;
    height: 1px;
    border: 1px solid #fff;
    margin-bottom: 10px;
  `,

  ScoreItem: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 50px;
    height: 50px;
  `,

  TeamNameBox: styled.div`
    display: flex;
    flex-direction: column;
    position: relative;
  `,

  TeamName: styled.div`
    width: 120px;
    margin: 10px;
    box-sizing: border-box;
    display: flex;
    justify-content: center;
  `,

  PopUpBackground: styled.div`
    display: ${({ isHover }) => (isHover ? BLOCK : NONE)};
    position: absolute;
    top: 0;
    left: 0;
    width: 1434px;
    height: 1080px;
    background: #222;
    opacity: 0.8;
    transition: display 1.5s;
    z-index: 10;
  `,
  PopUpButton: styled.div`
    width: 100px;
    height: 30px;
    border-radius: 0px 0px 50% 50%;
    position: absolute;
    bottom: -30px;
    left: 750px;
    background: gray;
    opacity: ${({ isHover }) => (isHover ? 1 : 0.5)};
    text-align: center;
    padding: 3px;
    z-index: 9999;
    border: 1px solid #fff;
    cursor: pointer;
    transition: all ease-in-out 0.4s;

    div {
      position: absolute;
      color: #fff;
      top: 2px;
      left: 43px;
      animation: ${ArrowFade} 1s infinite ease-in alternate;
    }
  `,

  AttackTeamTag: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 50px;
    height: 50px;
  `,

  CurrentPlayerTag: styled.div`
    width: fit-content;
    font-size: 6px;
    text-align: center;
    font-weight: 500;
    color: red;
    border-radius: 8px;
    border: 1px solid red;
    background: ${theme.COLOR.CURRENT_PLAYER_TAG};
    padding: 3px;
    margin: 3px;
    position: absolute;
    top: 33px;
    left: 44px;
  `,
};

export { ScoreBoardStyles };
