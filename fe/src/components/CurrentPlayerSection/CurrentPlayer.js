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
  color:white;
  
  /* ::after {
    content: ${props => props.value};
    content: "투수"
  } 왜 안되지? */ 
`

const CurrentPlayerStatus = styled.div`
  display: flex;
  font-size: 3rem;
  
  span + span {
    padding-left: 3%;
  }
`
const CurrentPlayerName = styled.span`
  color: blue;
`
const CurrentPlayerDetails = styled.span`
  color: blue;
`

export default CurrentPlayer;