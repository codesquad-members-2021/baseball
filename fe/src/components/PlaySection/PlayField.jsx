import styled from "styled-components";
import PlayFieldCanvas from "./PlayFieldCanvas";

const PlayField = () => {
  return (
    <div>
      <PlayFieldCanvas />
      {/* <RunningHomeToFirst />
      <RunningFirstToSecond />
      <RunningSecondToThird />
      <RunningThirdToHome /> */}
      <PlayerOnFirstBase />
      <PlayerOnSecondBase />
      <PlayerOnThirdBase />
    </div>
  );
};

const StandingPlayer = styled.img.attrs({
  src: `${"https://i.pinimg.com/originals/f7/5f/f2/f75ff23cd22d200f24bfd21f3a8b1f86.gif"}`,
})`
  width: 6rem;
  @media (max-width: 1200px) {
    width: 5rem;
  }
  @media (max-width: 768px) {
    width: 4rem;
  }
`;
const RunningPlayer = styled.img.attrs({
  src: `${"https://media.tenor.com/images/6d02cd24ab50932ca62ce555d74e384c/tenor.gif"}`,
})``;

const RunningHomeToFirst = styled(RunningPlayer)`
  //display:none;
  width: 7rem;
  position: absolute;
  bottom: 10%;
  left: 48%;
  animation-name: homeToFirst;
  animation-duration: 3s;
  animation-iteration-count: infinite;

  @keyframes homeToFirst {
    from {
      bottom: 10%;
      left: 48%;
    }
    to {
      bottom: 48%;
      left: 86%;
    }
  }
  @media (max-width: 1200px) {
    width: 5rem;
  }
  @media (max-width: 768px) {
    width: 4rem;
  }
`;
const RunningFirstToSecond = styled(RunningPlayer)`
  //display:none;
  width: 7rem;
  position: absolute;
  transform: rotateY(180deg);
  animation-name: firstToSecond;
  animation-duration: 3s;
  animation-iteration-count: infinite;

  @keyframes firstToSecond {
    from {
      top: 40%;
      right: 9%;
    }
    to {
      top: 17%;
      right: 48%;
    }
  }
  @media (max-width: 1200px) {
    width: 5rem;
  }
  @media (max-width: 768px) {
    width: 4rem;
  }
`;

const RunningSecondToThird = styled(RunningPlayer)`
  //display:none;
  width: 7rem;
  position: absolute;
  transform: rotateY(180deg);
  animation-name: secondToThird;
  animation-duration: 3s;
  animation-iteration-count: infinite;

  @keyframes secondToThird {
    from {
      top: 17%;
      left: 48%;
    }
    to {
      top: 43%;
      left: 9%;
    }
  }
  @media (max-width: 1200px) {
    width: 5rem;
  }
  @media (max-width: 768px) {
    width: 4rem;
  }
`;

const RunningThirdToHome = styled(RunningPlayer)`
  //display:none;
  width: 7rem;
  position: absolute;
  animation-name: thirdToHome;
  animation-duration: 3s;
  animation-iteration-count: infinite;

  @keyframes thirdToHome {
    from {
      top: 43%;
      left: 9%;
    }
    to {
      top: 80%;
      left: 48%;
    }
  }
  @media (max-width: 1200px) {
    width: 5rem;
  }
  @media (max-width: 768px) {
    width: 4rem;
  }
`;

const PlayerOnFirstBase = styled(StandingPlayer)`
  position: absolute;
  top: 40%;
  right: 9%;

  @media (max-width: 1200px) {
    top: 39%;
    right: 8%;
  }
  @media (max-width: 768px) {
    top: 45%;
    right: 8%;
  }
`;

const PlayerOnSecondBase = styled(StandingPlayer)`
  position: absolute;
  top: 17%;
  right: 48%;

  @media (max-width: 1200px) {
    top: 16%;
    right: 47%;
  }
  @media (max-width: 768px) {
    top: 18%;
    right: 47%;
  }
`;

const PlayerOnThirdBase = styled(StandingPlayer)`
  position: absolute;
  top: 43%;
  left: 9%;

  @media (max-width: 1200px) {
    top: 39%;
    left: 8%;
  }
  @media (max-width: 768px) {
    top: 45%;
    left: 8%;
  }
`;
export default PlayField;
