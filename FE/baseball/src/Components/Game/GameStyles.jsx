import styled from "styled-components";
import * as CS from "@/Styles/CommonStyles";
import theme from "@/Styles/theme";

// GameHeader에 사용되는 스타일 컴포넌트를 한 객체에 몰아넣어 봤습니다.
const GameHeader = {
  GameHeader: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)`
    border: 3px solid #fff;
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

export { GameHeader };
