import styled from 'styled-components';

const Stadium = () => {
  return (
    <StadiumDiv>
      {/* <ImgDiv> */}
      {/* <img src='./baseballRound.jpg' width='100%' height='100%' /> */}
      {/* <img src={require('./baseballRound.jpg')} /> */}
      {/* </ImgDiv> */}
    </StadiumDiv>
  );
};

const StadiumDiv = styled.div`
  box-sizing: border-box;
  opacity: 40%;
  background-image: url('./baseballRound.jpg');
  background-position: center;
  background-size: cover;
  /* overflow: hidden; */
  /* position: relative; */
`;
const ImgDiv = styled.div`
  position: absolute;
  top: 0;
  left: 0;
  width: fit-content;
  height: fit-content;
  background-color: black;
  opacity: 0.5;
  /* border: 4px solid red; */
`;

export default Stadium;
