import styled from 'styled-components';

const HistoryCard = () => {
  return (
    <HistoryCardLayout>
      <HistoryCardRow>
        <HistoryCardTitle>7번 타자 류현진</HistoryCardTitle>
      </HistoryCardRow>
      <HistoryCardRow>
        <HistoryCardHitResult> 
          <span className="offset"></span>
          <span className="result">안타!</span>
          <span className="offset"></span>
        </HistoryCardHitResult>
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
  padding: 10%;
  box-sizing: border-box;

  display: flex;
  flex-direction: column;
`

const HistoryCardRow = styled.div`
  width: 100%;
`

const HistoryCardTitle = styled.span`
  font-size: 3rem;
`

const HistoryCardHitResult = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  font-size: 2.5rem;

  .offset {
    ::after {
      content: ""
    }
  }
`
const HistoryCardPitchResult = styled.div`
  width: 100%;
  display: flex;
  justify-content: space-between;
  font-size: 2.5rem;
  
  .number {

  }
  .result {
    color:white
  }
  .status {
    color:grey;
  }
`

export default HistoryCard
