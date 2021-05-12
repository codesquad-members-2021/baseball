import React, { useContext, useEffect, useRef } from "react";
import styled from "styled-components";
import TopPopup from "./TopPopup";
import BottomPopup from "./BottomPopup";
import useTogglePopup from "utils/hooks/useTogglePopup";
import useAsync from "utils/hooks/useAsync";
import API from "utils/API";
import { GamePageContext } from "Components/GamePage";

const Popup = () => {
  const [isHidePopupState, setTogglePopupState] = useTogglePopup({
    top: true,
    bottom: true,
  });
  const $PopupBackground = useRef(null);
  const distance = 15;
  const { teamState: { gameId } } = useContext(GamePageContext);
  const [scoreState, fetchScoreState] = useAsync(API.get.scores, [], true);

  const loadTopPopupState = () => {
    setTogglePopupState("top")
    fetchScoreState(gameId);
  }

  const handleMoveShowPopup = ({ target, clientY }) => {
    if (target === $PopupBackground.current) return;
    if (clientY < distance) return setTogglePopupState("top");
    if (window.innerHeight - distance < clientY) {
      return setTogglePopupState("bottom");
    }
  };


  const handleClickHidePopup = ({ target }) => {
    if (target === $PopupBackground.current) setTogglePopupState("all");
  };

  useEffect(() => {
    window.addEventListener("mousemove", handleMoveShowPopup);
    return () => {
      window.removeEventListener("mousemove", handleMoveShowPopup);
    };
  }, []);

  return (
    <Background
      onClick={handleClickHidePopup}
      ref={$PopupBackground}
      {...{ isHidePopupState }}
    >
      <TopPopup {...{ isHidePopupState, distance }} />
      <BottomPopup {...{ isHidePopupState, distance }} />
    </Background>
  );
};

const Background = styled.div`
  position: absolute;
  background: linear-gradient(rgba(0, 0, 0, 0.8), rgba(0, 0, 0, 0.8));
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
  visibility: ${({ isHidePopupState: { top, bottom } }) =>
    !top || !bottom ? "visible" : "hidden"};
  opacity: ${({ isHidePopupState: { top, bottom } }) =>
    !top || !bottom ? "1" : "0"};
  transition: all 0.5s ease-in;
  z-index: 1;
`;

export default Popup;
