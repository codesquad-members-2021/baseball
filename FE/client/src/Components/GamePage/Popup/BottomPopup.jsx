import React, { useContext, useEffect } from "react";
import styled, { css } from "styled-components";
import API from "utils/API";
import useAsync from "utils/hooks/useAsync";
import { GamePageContext } from "Components/GamePage";
import PlayerScoreTable from "./PlayerScoreTable";

const BottomPopup = ({ isHidePopupState: { bottom }, distance }) => {
  const { teamState: { home, away } } = useContext(GamePageContext);
  const [homeTeamRecodes, fetchHomeTeamRecodes] = useAsync(API.get.records, [], true);
  const [awayTeamRecodes, fetchAwayTeamRecodes] = useAsync(API.get.records, [], true);


  useEffect(() => {
    if (bottom) return;
    fetchHomeTeamRecodes(home.teamId);
    fetchAwayTeamRecodes(away.teamId);
  }, [bottom]);

  return (
    <BottomPopupWrapper {...{ distance, bottom }}>

      {awayTeamRecodes.loading && <>loading...</>}

      {awayTeamRecodes.data && <>
        <TeamNamesWrapper player={home.isMyTeam}>{home.teamName}</TeamNamesWrapper>
        <TeamNamesWrapper player={away.isMyTeam}>{away.teamName}</TeamNamesWrapper>
        <PlayerScoreTable records={homeTeamRecodes} />
        <PlayerScoreTable records={awayTeamRecodes} />
      </>}


      {awayTeamRecodes.error && <>error...</>}
    </BottomPopupWrapper>
  );
};

const BottomPopupWrapper = styled.div`
  position: fixed;
  display: grid;
  height: 80vh;
  width: 75%;
  min-width: 38rem;
  padding: 1.2rem;
  margin: 0 auto;
  border: 0.2rem solid #fff;
  background: #000;
  box-sizing: border-box;
  grid-template-columns: repeat(2, 1fr);
  grid-template-rows: 1fr 20fr;
  bottom: ${({ distance }) => distance}px;
  left: 0;
  right: 0;
  color: #fff;
  transform: ${({ bottom }) => (bottom ? "translateY(85vh)" : "translateY(0)")};
  transition: all 0.5s ease-out;
  z-index: 1;
  & > div:not(:nth-child(2n)) {
    border-right: 2px solid #fff;
  }
  & > div:not(:nth-last-child(-n + 2)) {
    border-bottom: 2px solid #fff;
  }
`;

const TeamNamesWrapper = styled.div`
  line-height: 1rem;
  text-align: center;
  font-size: 2rem;
  font-weight: 700;
  ${({ player }) =>
    player &&
    css`
      &::after {
        content: "Player";
        position: absolute;
        margin-left: 1rem;
        color: red;
        font-size: 1.2rem;
      }
    `}
`;

export default BottomPopup;
