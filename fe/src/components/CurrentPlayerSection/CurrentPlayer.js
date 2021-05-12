import styled from 'styled-components';

const CurrentPlayer = (props) => {
  return (
    <CurrentPlayerLayout className={props.className}>
      <CurrentPlayerRow>
        <CurrentPlayerPosition> 투수 </CurrentPlayerPosition>
        <CurrentPlayerStatus>
          <CurrentPlayerName>최동원</CurrentPlayerName>
          <CurrentPlayerDetails>#39</CurrentPlayerDetails>
        </CurrentPlayerStatus>
      </CurrentPlayerRow>
      <CurrentPlayerRow>
        <CurrentPlayerPosition> 타자 </CurrentPlayerPosition>
        <CurrentPlayerStatus>
          <CurrentPlayerName>류현진</CurrentPlayerName>
          <CurrentPlayerDetails>1타석 0안타</CurrentPlayerDetails>
        </CurrentPlayerStatus>
      </CurrentPlayerRow>
    </CurrentPlayerLayout>
  )
}

const CurrentPlayerLayout = styled.section`
  width: 100%;
  
  display: flex;
  flex-direction: column;
  justify-content: center;
`;

const CurrentPlayerRow = styled.div`
  width: 100%;
  padding: 0 5%;
  
  display: flex;
  flex-direction: column;

  & + & {
    padding-top: 5%;
  }
`
const CurrentPlayerPosition = styled.span`
  font-size: 4rem;
  font-weight: 500;
  color:white;
  
  /* ::after {
    content: ${props => props.value};
    content: "투수"
  } 왜 안되지? */ 
`

const CurrentPlayerStatus = styled.div`
  font-size: 3rem;
  font-weight: 600;
  
  display: flex;
  
  span + span {
    padding-left: 3%;
  }
`
const CurrentPlayerName = styled.span`
  color: rgb(189, 228, 235);
`
const CurrentPlayerDetails = styled.span`
  color: rgb(103, 166, 192);
`

export default CurrentPlayer;