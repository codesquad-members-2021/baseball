import styled from 'styled-components';
import * as CS from '@/Styles/CommonStyles';
import { BLOCK, NONE } from '@/Utils/const';

const ScoreBoardStyles = {
  ScoreBoard: styled(CS.BOX.FLEX_CENTER_BOX)`
    position: absolute;
    top: ${({ scoreBoardPosition }) => `${scoreBoardPosition}px`};
    left: 350px;
    width: fit-content;
    font-weight: 900;
    font-size: 24px;
    padding: 0 40px;
    border: 1px solid #fff;
    background: #222;
    transition: all ease-in-out 0.8s;
    cursor: pointer;
  `,

  ScoreTable: styled(CS.BOX.FLEX_COLUMN_CENTER_BOX)`
    display: flex;
    justify-content: flex-end;
  `,

  ScoreRow: styled(CS.BOX.FLEX_CENTER_BOX)``,
  ScoreRowHead: styled(CS.BOX.FLEX_CENTER_BOX)`
    border-bottom: 3px solid #fff;
  `,

  ScoreItem: styled(CS.BOX.FLEX_CENTER_BOX)`
    width: 50px;
    height: 50px;
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
  `,
  PopUpButton: styled.div`
    display: ${({ isMouseOver }) => (isMouseOver ? NONE : BLOCK)};
    width: 100px;
    height: 30px;
    border-radius: 0px 0px 50% 50%;
    position: absolute;
    bottom: -30px;
    right: 0px;
    background: gray;
    opacity: 0.5;
    text-align: center;
    padding: 3px;
    z-index: 99999;
    border: 1px solid #fff;
    cursor: pointer;
    &:hover {
      opacity: 0.7;
    }
    div {
      position: absolute;
      top: 3px;
      left: 43px;
    }
  `,

  AttackTeamTag: styled.div`
    border: 1px solid red;
  `,
};

export { ScoreBoardStyles };
