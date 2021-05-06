import React from 'react';
import styled from 'styled-components';

const PlayerScoreTable = () => {
  const scoreTitleArray = ['타자', '타석', '안타', '아웃', '평균'];

  return (
    <div>
      <PlayerTable>
        <thead>
          <tr>
            {scoreTitleArray.map((title, idx) => {
              return <th key={`scoreTitle-${idx}`}>{title}</th>
            })}
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>김광진</td> <td>1</td> <td>0</td> <td>1</td> <td>1.000</td>
          </tr>
          <tr>
            <td>Totals</td><td>9</td> <td>4</td> <td>5</td>
          </tr>
        </tbody>
      </PlayerTable>
    </div>
  );
};

const PlayerTable = styled.table`
  width: 100%;
  height: 100%;
  padding-top: .4rem;
  font-size: 1.6rem;
  text-align: center;

  & > thead  {
    box-shadow:0px 2px 0px 0px #716E6E;
    color: #747171;
    line-height:2.5rem;
  } 

  & > tbody > tr {
    box-shadow:0px 2px 0px 0px #201F1F;
    &:last-child{
      font-weight: 700;
      box-shadow: none;
    }
    & > :first-child{
      min-width:5rem;
    }
    & > :last-child{
      min-width: 4rem;
    }
  }
`;
export default PlayerScoreTable;
