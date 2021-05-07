import styled from 'styled-components';

const Stadium = () => {
  return (
    <StadiumDiv>
      <div>Stadium</div>
    </StadiumDiv>
  );
};

const StadiumDiv = styled.div`
  background-image: url('../../utils/baseballRound.jpg');
  z-index: 10;
`;

export default Stadium;
