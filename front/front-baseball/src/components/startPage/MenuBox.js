import { useEffect } from "react";
import styled, { css } from "styled-components";
import { MESSAGE } from "../../utils/constant.js";
import Game from "./Game";
const MenuBox = () => {
  const testArray = [1, 2, 3, 4, 5, 6];
  useEffect(() => {});
  return (
    <MenuWrapper>
      <MessageBox>{MESSAGE.INIT}</MessageBox>
      <Games>
        {testArray.map((el) => (
          <Game />
        ))}
      </Games>
    </MenuWrapper>
  );
};
const MenuWrapper = styled.div`
  margin-top: 1rem;
  width: 30%;
`;
const MessageBox = styled.div`
  text-align: center;
  color: white;
  margin: 3rem 0;
  font-size: 2rem;
`;
const Games = styled.div`
  height: 500px;
  display: flex;
  flex-direction: column;
  overflow: scroll;
  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;
export default MenuBox;
