import React from 'react';
import styled, { css, keyframes } from 'styled-components';
import ReadyPlayerImage from 'Images/readyPlayer.svg';

const ReadyImage = ({ base }) => {
  return (
    <ReadyWrapper base={base}>
      <ReadyImageTag src={ReadyPlayerImage} alt="" />
    </ReadyWrapper>
  );
};

const readyLocation = {
  first: `top: 35%;
  left: 84%;
  transform: rotate(45deg);`,
  second: `top: 3%;
  left: 33%;
  transform: rotate(-45deg);`,
  third: `top: 54%;
  left: 3%;
  transform: rotate(225deg);`,
};

const show = keyframes`
  0% {
    opacity:0;
  }
  90%{
    opacity:0;
  }
  100% {
    opacity:1;
  }
`;


const ReadyWrapper = styled.div`
  width:13%;
  position: absolute;
  animation: ${show} 1.7s;
  ${({ base }) => base && css`
    ${readyLocation[base]}
  `
  }
`;

const ReadyImageTag = styled.img`
  width: 100%;
`;

export default ReadyImage;
