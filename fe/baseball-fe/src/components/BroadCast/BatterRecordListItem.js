import styled from 'styled-components';
import { useContext } from 'react';
import { GameContext } from 'util/context.js';

function BatterRecordListItem({ data }) {
  const { gameState } = useContext(GameContext);

  const getActionString = (action) => {
    if (action === 'STRIKE') return '스트라이크';
    if (action === 'BALL') return '볼';
    if (action === 'OUT') return '아웃!';
    if (action === 'HIT') return '안타!';
    return '볼넷!';
  }

  const renderRecords = () => {
    return data.records.map((record, idx) =>
      <Record key={data.records.length - idx}>
        {record.action === 'OUT' || record.action === 'HIT' || record.action === 'BALL4' ?
          <div className='hit-or-out'>{getActionString(record.action)}</div> :
          <>
            <div className='number'>{data.records.length - idx}</div>
            <div className='action'>{getActionString(record.action)}</div>
            <div className='strike-ball'>{`S${record.strike} B${record.ball}`}</div>
          </>
        }
      </Record>
    );
  }

  return (
    <StyledBatterRecordListItem className={gameState.batter.id === data.id ? 'current' : ''}>
      {gameState.batter.id === data.id ? '' : data.title}
      <InnerRecordList>
        {renderRecords()}
      </InnerRecordList>
    </StyledBatterRecordListItem>
  )
}

export default BatterRecordListItem;

const StyledBatterRecordListItem = styled.li`
  margin-top: 1rem;
  color: skyblue;
`;

const InnerRecordList = styled.ul`
  list-style: none;
  padding: 0 1rem;
`

const Record = styled.li`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0;
  color: white;
  line-height: 1rem;
  margin-top: 0.5rem;

  .hit-or-out {
    margin: 0 auto;
    color: steelblue;
    font-weight: 800;
  }
`;
