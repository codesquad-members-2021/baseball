import styled from "styled-components";

const PlayInning = ({ currentInning }) => {
  return <Inning>2회초 수비</Inning>;
};
//2랑 초 수비 / 말 공격 state로 받기

const Inning = styled.div`
  position: absolute;
  top: 5%;
  right: 2%;
  color: white;
  font-size: 2rem;
`;

export default PlayInning;
