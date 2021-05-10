import styled from "styled-components";

// 캔버스로 경기장 새로 그리기, 선수 이동 애니메이션 적용
const PlayField = () => {
  return (
    <div>
      <FieldLine />
      <RunningPlayer />
      <PlayerOnFirstBase />
      <PlayerOnSecondBase />
      <PlayerOnThirdBase />
    </div>
  );
};

const FieldLine = styled.div`
  position: absolute;
  top: 52%;
  right: 5%;
  width: 4px;
  height: 100px;
  background-color: #fff;
  transform: rotate(55deg);

  @media (max-width: 1024px) {
  }
  @media (max-width: 768px) {
  }
`;
const StandingPlayer = styled.img.attrs({
  src: `${"https://i.pinimg.com/originals/f7/5f/f2/f75ff23cd22d200f24bfd21f3a8b1f86.gif"}`,
})`
  width: 5rem;
  @media (max-width: 1024px) {
    width: 3rem;
  }
  @media (max-width: 768px) {
    width: 2rem;
  }
`;

const RunningPlayer = styled.img.attrs({
  src: `${"https://media.tenor.com/images/6d02cd24ab50932ca62ce555d74e384c/tenor.gif"}`,
})`
  width: 5rem;
  position: absolute;
  top: 55%;
  left: 70%;

  @media (max-width: 1024px) {
    width: 3rem;
  }
  @media (max-width: 768px) {
    width: 2rem;
  }
`;

const PlayerOnFirstBase = styled(StandingPlayer)`
  position: absolute;
  top: 45%;
  right: 10%;

  @media (max-width: 1024px) {
    top: 48%;
    right: 10%;
  }
  @media (max-width: 768px) {
    width: 2rem;
  }
`;

const PlayerOnSecondBase = styled(StandingPlayer)`
  position: absolute;
  top: 24%;
  right: 49%;
`;

const PlayerOnThirdBase = styled(StandingPlayer)`
  position: absolute;
  top: 45%;
  left: 6%;
`;
export default PlayField;
