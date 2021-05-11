import styled from "styled-components";

const PlayInning = ({ currentInning }) => {
  return <Inning>2회초 수비</Inning>;
};
//2랑 초 수비 / 말 공격 state로 받기

const Inning = styled.div`
  position: absolute;
  top: 4%;
  right: 4%;
  color: white;
  font-size: 4rem;

  @media (max-width: 1200px) {
    font-size: 2rem;
  }
  @media (max-width: 768px) {
    font-size: 1rem;
  }
`;

export default PlayInning;
