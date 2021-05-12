import styled, { keyframes } from 'styled-components';
import * as CS from '@/Styles/CommonStyles';
import theme from '@/Styles/theme';

const ArrowFade = keyframes`
0% {
  bottom: 0px;
  opacity: 0;
}
50% {
  bottom: 1.5px;
  opacity: 0.4;
}
100% {
  bottom: 3px;
  opacity: 0.8;
}
`;

const Game = {
  Game: styled(CS.BOX.FLEX_ROW_BOX)`
    position: relative;
    border: 3px solid ${theme.COLOR.DEFAULT};
    background: #111;
    opacity: 0.8;
    width: 1440px;
    height: 1080px;
  `,
  GameLeftSection: styled(CS.BOX.FLEX_COLUMN_BOX)`
    position: relative;
    width: 80%;
    height: 100%;
    border-right: 3px solid gray;
  `,
  GameRightSection: styled(CS.BOX.FLEX_COLUMN_BOX)`
    width: 20%;
    height: 100%;
  `,

  Background: styled.img`
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    z-index: -999;
    opacity: 0.4;
    filter: blur(5px);
  `,
};

const GameHeader = {
  GameHeader: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)`
    border-bottom: 3px solid gray;
    height: 18%;
    padding: 30px;
  `,
  GameTitle: styled.div`
    font-size: ${theme.FONTSIZE.S};
    font-weight: 700;
    margin-bottom: 30px;
  `,
  GameProgress: {
    GameProgress: styled(CS.BOX.FLEX_ROW_BOX)``,
    VS: styled.div`
      font-size: ${theme.FONTSIZE.L};
      font-weight: 700;
      color: ${theme.COLOR.VS};
      padding: 10px;
    `,
    TeamName: styled.div`
      font-size: ${theme.FONTSIZE.XXL};
      font-weight: 700;
    `,
    TeamNameWrapper: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)``,
    Score: styled.div`
      font-size: ${theme.FONTSIZE.XXL};
      font-weight: 700;
      margin: 0px 20px;
    `,
    CurrentPlayerTag: styled.div`
      width: 100px;
      text-align: center;
      font-size: ${theme.FONTSIZE.XS};
      font-weight: 500;
      color: red;
      border-radius: 8px;
      border: 1px solid red;
      background: ${theme.COLOR.CURRENT_PLAYER_TAG};
      padding: 5px;
      margin: 10px;
    `,
  },
};

const GamePlayground = {
  GamePlayground: styled(CS.BOX.FLEX_COLUMN_BOX)`
    position: relative;
    height: 82%;
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

  InningInfo: styled.div`
    position: absolute;
    top: 0;
    right: 0;
    font-size: ${theme.FONTSIZE.M};
    font-weight: 600;
    padding: 10px;
  `,

  PitchButton: styled.button`
    position: absolute;
    top: 50%;
    left: 44%;
    width: 150px;
    outline: none;
    border: 2px solid ${theme.COLOR.DEFAULT};
    border-radius: 8px;
    background: #222;
    color: ${theme.COLOR.DEFAULT};
    font-family: 'Orbitron', sans-serif;
    font-size: ${theme.FONTSIZE.M};
    padding: 10px;
    z-index: 999;
  `,

  GameDisplay: styled.div`
    position: absolute;
    bottom: -3%;
    left: 9%;
  `,

  Runner: styled(CS.BOX.FLEX_CENTER_BOX)`
    position: absolute;
    font-size: 80px;
    transition: all ease-in-out 1s;

    /* base */
    /* top: 740px;
    left: 440px; */
    /* 1 */
    /* top: 450px;
    left: 650px; */
    /* 2 */
    top: 230px;
    left: 440px;
    /* 3 */
    /* top: 450px;
    left: 230px; */
  `,

  Base: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 49px;
    height: 49px;
    border: 1px solid red;
    background: red;
    opacity: 0.8;
    transform: rotate(45deg);
    position: absolute;
    z-index: -1;
    /* 1 */
    top: 491px;
    left: 669px;
    /* 2 */
    top: 272px;
    left: 451px;
    /* 3 */
    top: 491px;
    left: 231px;
  `,

  HomeBase: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 114px;
    height: 114px;
    border: 1px solid red;
    border-radius: 50%;
    background: red;
    opacity: 0.8;
    position: absolute;
    z-index: -1;
    top: 732px;
    left: 418px;
  `,

  BallCountBoard: {
    BallCountBoard: styled(CS.BOX.FLEX_COLUMN_BOX)`
      position: absolute;
      top: 0;
      left: 0;
      padding: 10px;
    `,
    BallJudgement: styled.span`
      font-size: ${theme.FONTSIZE.M};
      font-weight: 600;
      margin-right: 10px;
    `,
    BallCount: styled.span`
      width: 25px;
      height: 25px;
      border: none;
      border-radius: 50%;
      margin-right: 3px;
      background: ${({ type }) => {
        switch (type) {
          case 'STRIKE':
            return theme.COLOR.BALLCOUNT_STRIKE;
          case 'BALL':
            return theme.COLOR.BALLCOUNT_BALL;
          case 'OUT':
            return theme.COLOR.BALLCOUNT_OUT;
          default:
            return;
        }
      }};
    `,
  },
};

const GamePlayLog = {
  GamePlayLog: styled(CS.BOX.FLEX_COLUMN_BOX)`
    width: 100%;
    height: 100%;
  `,
  CurrentPlayer: {
    CurrentPlayer: styled(CS.BOX.FLEX_COLUMN_BOX)`
      padding: 30px;
      height: 18%;
      border-bottom: 3px solid gray;
      justify-content: space-between;
    `,
    Position: styled.div`
      font-size: 1.75rem;
      font-weight: 600;
      margin-bottom: 5px;
    `,
    PlayerName: styled.span`
      font-size: ${theme.FONTSIZE.S};
      color: ${theme.COLOR.PLAYER_NAME};
      margin-right: 10px;
    `,
    PlayerDescription: styled.span`
      font-size: ${theme.FONTSIZE.S};
      color: ${theme.COLOR.PLAYER_DESCRIPTION};
    `,
  },
  PlayerLog: {
    PlayerLog: styled(CS.BOX.FLEX_COLUMN_BOX)`
      height: 82%;
      padding: 30px;
    `,
    LogTitle: styled.div`
      font-weight: 600;
      color: ${({ isCurrentPlayer }) =>
        isCurrentPlayer ? 'red' : theme.COLOR.PLAYER_NAME};
    `,
    Log: styled.div`
      padding: 20px 0px;
    `,
    LogRow: styled(CS.BOX.FLEX_ROW_CENTER_BOX)`
      margin-bottom: 10px;
    `,
    LogRowNumber: styled.div`
      width: 20px;
      height: 20px;
      border: 2px solid #222;
      border-radius: 50%;
      color: #222;
      background: ${theme.COLOR.DEFAULT};
      text-align: center;
      margin-right: 20px;
    `,
    LogRowAction: styled.div`
      margin-right: 40px;
      font-weight: 700;
      color: ${({ isEndAction }) =>
        isEndAction ? theme.COLOR.LOG_END_ACTION : theme.COLOR.DEFAULT};
    `,
    LogRowBallCount: styled.div`
      color: ${theme.COLOR.LOG_BALLCOUNT};
    `,
  },
};

const SquadBoard = {
  SquadBoard: styled(CS.BOX.FLEX_ROW_BOX)`
    position: absolute;
    bottom: ${({ isMouseOver }) => (isMouseOver ? '5px' : '-1080px')};
    left: 5%;
    width: 70%;
    height: 77%;
    background: #222;
    padding: 30px;
    z-index: 999;
    border-radius: 8px;
    border: 3px solid ${theme.COLOR.DEFAULT};
    transition: all 1s;
  `,
  SquadBoardWrapper: styled.div`
    position: absolute;
    top: 0;
    left: 0;
    width: 1440px;
    height: 1080px;
    overflow: hidden;
  `,
  PopUpBackground: styled.div`
    position: absolute;
    display: ${({ isMouseOver }) => (isMouseOver ? 'block' : 'none')};
    left: 0;
    width: 99.6%;
    height: 99.4%;
    background: #222;
    opacity: 0.8;
    transition: all 1s;
  `,
  PopUpButton: styled.div`
    width: 100px;
    height: 25px;
    border-radius: 50% 50% 0px 0px;
    position: absolute;
    bottom: 5px;
    left: 530px;
    background: gray;
    opacity: 0.5;
    text-align: center;
    padding: 3px;
    z-index: 999;
    &:hover {
      opacity: 0.7;
    }
    div {
      position: absolute;
      left: 42.5%;
      animation: ${ArrowFade} 1s infinite ease-in alternate;
    }
  `,
  SquadTable: {
    SquadTable: styled.div`
      padding: 20px;
      border-radius: 8px;
      border: 3px solid ${theme.COLOR.DEFAULT};
      width: 45%;
      margin: 0px 30px;
    `,
    SquadTableHeader: styled.div`
      position: relative;
      font-size: ${theme.FONTSIZE.S};
      font-weight: 700;
      text-align: center;
      border-bottom: 3px solid ${theme.COLOR.DEFAULT};
      padding-bottom: 10px;
    `,
    CurrentPlayerTag: styled.div`
      position: absolute;
      top: 5px;
      right: 0;
      width: 70px;
      text-align: center;
      font-size: 0.75rem;
      font-weight: 300;
      color: red;
      border-radius: 8px;
      border: 1px solid red;
      background: ${theme.COLOR.CURRENT_PLAYER_TAG};
      padding: 5px;
    `,
    SquadTableBody: styled.table`
      width: 100%;
      height: 95%;
    `,
    SquadTableRow: styled.tr`
      border-bottom: 1px solid ${theme.COLOR.PLAYER_DESCRIPTION};
      text-align: center;
      color: ${({ isCurrentPlayer }) =>
        isCurrentPlayer ? 'red' : theme.COLOR.DEFAULT};
    `,
    SquadTableData: styled.td`
      vertical-align: middle;
    `,
  },
};

export { Game, GameHeader, GamePlayground, GamePlayLog, SquadBoard };
