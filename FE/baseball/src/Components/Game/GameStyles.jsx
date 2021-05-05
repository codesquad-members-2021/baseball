import styled from "styled-components";
import * as CS from "@/Styles/CommonStyles";
import theme from "@/Styles/theme";

// GameHeader에 사용되는 스타일 컴포넌트를 한 객체에 몰아넣어 봤습니다.
const Game = styled(CS.BOX.FLEX_COLUMN_BOX)`
  border: 3px solid #fff;
  width: 1440px;
  height: 1080px;
`;

const GameHeader = {
  GameHeader: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)`
    border: 3px solid pink;
    width: 80%;
  `,
  GameTitle: styled.div`
    font-size: 1.5rem;
    font-weight: 700;
    margin: 30px 0px;
  `,
  //GameProgress는 폴더라서 또 객체로 만들어 봤습니다.
  GameProgress: {
    GameProgress: styled(CS.BOX.FLEX_ROW_BOX)``,
    VS: styled.div`
      font-size: 2.5rem;
      font-weight: 700;
      color: ${theme.COLOR.VS};
      padding-top: 10px;
    `,
    TeamName: styled.div`
      font-size: 3.5rem;
      font-weight: 700;
    `,
    TeamNameWrapper: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)``,
    Score: styled.div`
      font-size: 3.5rem;
      font-weight: 700;
      margin: 0px 20px;
    `,
    CurrentPlayerTag: styled.div`
      width: 100px;
      text-align: center;
      font-weight: 500;
      color: red;
      border-radius: 8px;
      border: 1px solid red;
      background: ${theme.COLOR.CURRENT_PLAYER_TAG};
      padding: 5px;
      margin: 5px;
    `,
  },
};

const GamePlayground = {
  GamePlayground: styled(CS.BOX.FLEX_COLUMN_BOX)`
    position: relative;
    border: 3px solid pink;
    width: 80%;
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
  `,

  InningInfo: styled.div`
    position: absolute;
    top: 0;
    right: 0;
    font-size: 2rem;
    font-weight: 600;
    padding: 10px;
  `,

  PitchButton: styled.button`
    position: absolute;
    top: 50%;
    left: 42%;
    width: 150px;
    outline: none;
    border: 2px solid #fff;
    border-radius: 8px;
    background: #222;
    color: #fff;
    font-family: "Orbitron", sans-serif;
    font-size: 2rem;
    padding: 10px;
  `,

  GameDisplay: styled.div`
    position: absolute;
    bottom: 0;
    left: 45%;
  `,

  BallCountBoard: {
    BallCountBoard: styled(CS.BOX.FLEX_COLUMN_BOX)`
      position: absolute;
      top: 0;
      left: 0;
      padding: 10px;
    `,
    BallJudgement: styled.span`
      font-size: 2rem;
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
          case "STRIKE":
            return theme.COLOR.BALLCOUNT_STRIKE;
          case "BALL":
            return theme.COLOR.BALLCOUNT_BALL;
          case "OUT":
            return theme.COLOR.BALLCOUNT_OUT;
          default:
            return;
        }
      }};
    `,
  },
};

const GamePlayLog = {};

export { Game, GameHeader, GamePlayground, GamePlayLog };
