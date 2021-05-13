import React from 'react';
import styled from 'styled-components';

const GameScoreTable = ({ teamScores }) => {
  const roundArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];

  return (
    <>
      <ScoreTable>
        <thead>
          <tr>
            {roundArray.map((round, idx) => {
              return <th key={`round-${idx}`}>{round}</th>
            })}
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>2</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
            <td>2</td>
          </tr>
          <tr>
            <td>3</td>
            <td>3</td>
            <td>3</td>
            <td>3</td>
            <td>3</td>
          </tr>
        </tbody>
      </ScoreTable>
      <TotalScoreTable>
        <thead>
          <tr>
            <th>R</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>2</td>
          </tr>
          <tr>
            <td>3</td>
          </tr>
        </tbody>
      </TotalScoreTable>
    </>
  );
};

const ScoreTable = styled.table`
  width: 100%; 
  border-collapse:separate;
  border-spacing: 0.4rem 1rem;
  & > thead > tr{
    box-shadow:0px 4px 0px 0px #fff;
    color: #fff;
  }
  & tr{
    margin-bottom: 2rem;
  }
  & th, td{
    width: 3rem;
    text-align: center;
    font-weight: 700;
  }
  font-size: 2rem;
`;

const TotalScoreTable = styled(ScoreTable)`
  width: 4.4rem;
  & > tbody{
    color: #DD5900; 
  }
`;

export default GameScoreTable;
