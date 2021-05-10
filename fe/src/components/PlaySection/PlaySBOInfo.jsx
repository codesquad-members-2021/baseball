import styled from "styled-components";

const PlaySBOInfo = ({ SBOState }) => {
  //ball type SBO 상태에 맞게 랜더링 하도록 수정 예정
  return (
    <SBOInfoLayout>
      <Row>
        <BallType>S</BallType>
        <Light active={true} bgColor="yellow"></Light>
        <Light active={true} bgColor="yellow"></Light>
        <Light active={false} bgColor="yellow"></Light>
      </Row>
      <Row>
        <BallType>B</BallType>
        <Light active={true} bgColor="green"></Light>
        <Light active={true} bgColor="green"></Light>
        <Light active={true} bgColor="green"></Light>
      </Row>
      <Row>
        <BallType>O</BallType>
        <Light active={true} bgColor="red"></Light>
        <Light active={true} bgColor="red"></Light>
        <Light active={true} bgColor="red"></Light>
      </Row>
    </SBOInfoLayout>
  );
};

const SBOInfoLayout = styled.div`
  position: absolute;
  top: 6%;
  left: 1%;
`;

const BallType = styled.div`
  width: 20%;
  padding: 0px 10px;
  font-weight: bold;
  text-align: center;

  color: white;
  font-size: 2.2rem;
`;

const Row = styled.div`
  display: flex;
`;

const Light = styled.div`
  display: inline-block;
  width: 2rem;
  height: 2rem;
  background-color: ${props => props.active && props.bgColor};
  border: 1px solid white;
  border-radius: 50%;

  & + & {
    margin-left: 2%;
  }
`;
export default PlaySBOInfo;
