import React from 'react';
import styled, { css } from 'styled-components';
import GameScoreTable from 'Components/GamePage/Popup/GameScoreTable';

const TopPopup = ({ isHidePopupState: { top }, distance }) => {

  return (
    <TopPopupWrapper {...{ top, distance }} >
      <TeamNamesWrapper>
        <TeamName player>Captain</TeamName>
        <TeamName >Marvel</TeamName>
      </TeamNamesWrapper>
      <GameScoreTable />
    </TopPopupWrapper>
  );
};

const TopPopupWrapper = styled.div`
  position: fixed;
  display: flex;
  height: 17rem;
  width: 75%;
  min-width: 38rem;
  margin: 0 auto;
  padding: 2rem 5rem 2rem 0;
  border: .2rem solid #fff;
  background: #000;
  box-sizing: border-box;
  top:${({ distance }) => distance}px;
  left: 0;
  right: 0;
  color: #fff;
  transition:  all 0.5s ease-out;
  transform: ${({ top }) => top ? 'translateY(-18rem)' : 'translateY(0px)'};
  z-index: 1;
`;

const TeamNamesWrapper = styled.div`
  width:12rem;
  margin: 4.2rem 1.5rem 0 0;
  font-size: 2rem;
  line-height: 3.7rem;
  text-align: end;
`;

const TeamName = styled.div`
  position:relative;
  width: max-content;
  margin-left: auto;
  ${({ player }) => player && css`
      &::after{
        content: 'Player';
        position: absolute;
        display: block;
        width: 100%;
        font-size: 0.9rem;
        color: red;
        top: 45%;
        font-weight: 700;
        text-align: center;
      }
  `}
`;

export default TopPopup;