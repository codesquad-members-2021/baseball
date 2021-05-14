import React from 'react';
import styled from 'styled-components';

const GameScoreTable = ({ teamScores }) => {
  const roundArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12];
  const [homeTotal, awayTotal] = teamScores.map(({ scores }) => {
    return scores.reduce((acc, { score }) => acc + score, 0);
  });

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
            {teamScores[0].scores.length
              ? teamScores[0].scores.map(({ score }, index) => (<td key={`homeScore-${index}`}>{score}</td>))
              : <td>-</td>}
          </tr>
          <tr>
            {teamScores[1].scores.length
              ? teamScores[1].scores.map(({ score }, index) => (<td key={`homeScore-${index}`}>{score}</td>))
              : <td>-</td>}
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
            <td>{homeTotal}</td>
          </tr>
          <tr>
            <td>{awayTotal}</td>
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