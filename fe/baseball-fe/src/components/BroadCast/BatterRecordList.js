import styled from 'styled-components';
import { useContext } from 'react';
import { GameContext } from 'util/context.js';

import BatterRecordListItem from './BatterRecordListItem.js';

function BatterRecordList() {
  const { records, gameState } = useContext(GameContext);
  
  const createOrganizedRecords = () => {
    const newRecords = [];

    for (let i = records.length - 1; i >= 0; i--) {
      const currRecord = records[i];
      const currBatter = {
        id: currRecord.player_id,
        title: `${currRecord.nth_batter}번 타자 ${currRecord.batter_name}`,
        records: [{ action: currRecord.action, strike: currRecord.strike, ball: currRecord.ball}]
      }

      for (let j = i - 1; j >= 0; j--) {
        const innerRecord = records[j];

        if (currRecord.player_id !== innerRecord.player_id)
          break;

        i = j;
        currBatter.records.push({ action: innerRecord.action, strike: innerRecord.strike, ball: innerRecord.ball });
      }

      newRecords.push(currBatter);
    }

    return newRecords;
  }

  const renderBatterRecordListItems = () => {
    return createOrganizedRecords().map((data, idx) => 
      <BatterRecordListItem key={idx} data={data}/>
    );
  }

  return (
    <StyledBatterRecordList>
      <div className='current'>{`${gameState.nth_batter}번 타자 ${gameState.batter.name}`}</div>
      {records && renderBatterRecordListItems()}
    </StyledBatterRecordList>
  )
}

export default BatterRecordList;

const StyledBatterRecordList = styled.ul`
  list-style: none;
  padding: 1rem;
  margin: 0;

  .current {
    color: orangered;
  }
`;


