import React from 'react';
import styled, { keyframes } from 'styled-components';
import BodyAndHead from 'Images/bodyAndHead.svg';
import ArmsImage from 'Images/arms.svg';
import Pants from 'Images/pants.svg';
import Foot from 'Images/foot.svg';

const RunnerImage = () => {
  return (
    <RunnerWrapper>
      <BodyAndHeadImageTag src={BodyAndHead} alt="" />
      <FrontArmImageTag src={ArmsImage} alt="" />
      <BackArmImageTag src={ArmsImage} alt="" />
      <FrontPantsImageTag src={Pants} alt="" />
      <BackPantsImageTag src={Pants} alt="" />
      <FrontFootImageTag src={Foot} alt="" />
      <BackImageTag src={Foot} alt="" />
    </RunnerWrapper>
  );
};
const upDown = keyframes`
  from {margin-top:-8px;}
  to {margin-top:0;}
`;

const RunnerWrapper = styled.div` 
  
  animation: ${upDown} .3s linear infinite alternate;
`;

const frontHand = keyframes`
  from {transform:rotate(20deg);}
  to{transform:rotate(-60deg);}
`;

const backHand = keyframes`
  from {transform:rotate(-30deg);}
  to{transform:rotate(50deg);}
`;

const frontPants = keyframes`
  from {transform:rotate(50deg);}
  to{transform:rotate(0);}
`;

const backPants = keyframes`
  from {transform:rotate(0);}
  to{transform:rotate(50deg);}
`;

const frontFoot = keyframes`
  from {transform:rotate(77deg);}
  ${'' /* 40% {transform:rotate(50deg);}
  50% {transform:rotate(0);}
  90% {transform:rotate(0);} */}
  to{transform:rotate(0);}
`;

const backFoot = keyframes`
  from {transform:rotate(0);}
  ${'' /* 40% {transform:rotate(0);}
  50% {transform:rotate(67deg);}
  90% {transform:rotate(50deg);} */}
  to{transform:rotate(77deg);}
`;

const BodyAndHeadImageTag = styled.img`
  position: absolute;
  top:50%;
  left:50%;
  width: 10%;
  z-index:3;
  transform:translate(-50%,-50%);
`;

const FrontArmImageTag = styled.img`
  position:absolute;
  z-index:4;
  top: 47.7%;
  left: 46%;
  width: 12%;
  animation: ${frontHand} .5s linear infinite alternate;
  transform-origin:50% 10%;
`;

const BackArmImageTag = styled.img`
  position:absolute;
  z-index:2;
  top: 47.7%;
  left: 46%;
  width: 12%;
  animation: ${backHand} .5s linear infinite alternate;
  transform-origin:50% 10%;
`;

const FrontPantsImageTag = styled.img`
  position:absolute;
  z-index:2;
  top: 56.3%;
  left: 45.2%;
  width: 10%;
  animation: ${frontPants} .5s linear infinite alternate;
  transform-origin:50% 10%;
`;
const BackPantsImageTag = styled.img`
 position:absolute;
  z-index:1;
  top: 56.3%;
  left: 45.2%;
  width: 10%;
  animation: ${backPants} .5s linear infinite alternate;
  transform-origin:50% 10%;
`;
const FrontFootImageTag = styled.img`
 position:absolute;
  z-index:2;
  top: 67.7%;
  left: 50.2%;
  width: 10%;
  animation: ${frontFoot} .5s linear infinite alternate;
  transform-origin:-15% -55%;
`;
const BackImageTag = styled.img`
 position:absolute;
  z-index:1;
  top: 67.7%;
  left: 50.2%;
  width: 10%;
  animation: ${backFoot} .5s linear infinite alternate;
  transform-origin:-15% -55%;
`;




export default RunnerImage;
