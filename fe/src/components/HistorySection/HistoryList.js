import styled from 'styled-components';

import HistoryCard from './HistoryCard.js';

const HistoryList = (props) => {
  return (
    <HistoryListLayout className={props.className}>
      <HistoryCard className={'history-card'} />
      <HistoryCard className={'history-card'} />
      <HistoryCard className={'history-card'} />
    </HistoryListLayout>
  )
}
const HistoryListLayout = styled.section`
  width: 100%;
  overflow: scroll;
  
  display: flex;
  flex-direction: column;

  .history-card + .history-card {
    margin-top: 5%;
  }
`
export default HistoryList;