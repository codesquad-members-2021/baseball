import styled from 'styled-components';

const HistoryCard = ({isCurrent}) => {
  return (
    <HistoryCardLayout>
      <HistoryCardRow>
        <HistoryCardTitle isCurrent={isCurrent}>7번 타자 류현진</HistoryCardTitle>
      </HistoryCardRow>
      <HistoryCardRow>
        <HistoryCardHitResult> 
          <span className="offset"></span>
          <span className="result">안타!</span>
          <span className="offset"></span>
        </HistoryCardHitResult>
        <HistoryCardPitchResult>
          <span className="number">12</span>
          <span className="result">스트라이크</span>
          <span className="status">S2 B3</span>
        </HistoryCardPitchResult>
        <HistoryCardPitchResult>
          <span className="number">1</span>
          <span className="result">스트라이크</span>
          <span className="status">S2 B3</span>
        </HistoryCardPitchResult>
        <HistoryCardPitchResult>
          <span className="number">1</span>
          <span className="result">스트라이크</span>
          <span className="status">S2 B3</span>
        </HistoryCardPitchResult>
        
      </HistoryCardRow>
    </HistoryCardLayout>
  )
}

const HistoryCardLayout = styled.div`
  width: 100%;
  max-width: 350px;
  padding: 10% 5%;
  box-sizing: border-box;

  display: flex;
  flex-direction: column;
`

const HistoryCardRow = styled.div`
  width: 100%;
`

const HistoryCardTitle = styled.span`
  font-size: 2.75rem;
  color: ${props => props.isCurrent ? `rgb(218, 52, 7)` : `rgb(189, 228, 235)`}; 
`

const HistoryCardHitResult = styled.div`
  width: 100%;
  font-size: 2.25rem;
  margin: 15px 0;

  display: flex;
  justify-content: space-between;

  .offset {
    ::after {
      content: ""
    }
  }
  .result {
    color: rgb(103, 166, 192);
  }
`
const HistoryCardPitchResult = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  align-items:center;
  font-size: 2.25rem;
  
  .number {
    width: 2.7rem;
    height: 2.7rem;
    background-color: white;
    color: black;
    border-radius:50%;
    box-sizing: border-box;

    display: flex;
    justify-content: center;
    align-items: flex-end;
  }
  .result {
    color:white
  }
  .status {
    color:grey;
  }

  & + & {
    margin-top: 15px;
  }
`

export default HistoryCard
