import React from 'react';
import styled from 'styled-components';

const PlayerScoreTable = ({ records }) => {
  const scoreTitleArray = ['타자', '타석', '안타', '아웃', '평균'];
  const total = records.reduce((acc, cur) => {
    acc.atBat += cur.atBat;
    acc.hit += cur.hit;
    acc.out += cur.out;
    return acc;
  }, { atBat: 0, hit: 0, out: 0 });

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
          {records.map(({ name, atBat, hit, out }, index) => {
            return (<tr key={`record-${index}`}>
              <td>{name}</td><td>{atBat}</td><td>{hit}</td><td>{out}</td><td>{getAverage({ hit, out })}</td>
            </tr>)
          })}
          <tr>
            <td>Totals</td><td>{total.atBat}</td><td>{total.hit}</td>
            <td>{total.out}</td><td>{getAverage({ hit: total.hit, out: total.out })}</td>
          </tr>
        </tbody>
      </PlayerTable>
    </div>
  );
};

const getAverage = ({ hit, out }) => {
  const isZero = (hit + out) === 0;
  const average = isZero ? '0.000' : (hit / (hit + out)).toFixed(3);
  return average;
}
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
