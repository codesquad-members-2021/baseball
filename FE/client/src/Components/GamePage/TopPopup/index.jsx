import React from 'react';
import styled, { css } from 'styled-components';


const TopPopup = () => {

  const roundArray = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 'R'];

  return (
    <GameScoreWrapper>
      <TeamNamesWrapper>
        <TeamName player>Captain</TeamName>
        <TeamName >Marvel</TeamName>
      </TeamNamesWrapper>
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
    </GameScoreWrapper>
  );
};

const GameScoreWrapper = styled.div`
  position: fixed;
  display:flex;
  height: 20rem;
  width: 90%;
  margin: 0 auto;
  padding: 2rem 5rem 2rem 0;
  border: .2rem solid #fff;
  background: #000;
  box-sizing:border-box;
  top:1rem;
  left: 0;
  right: 0;
  z-index: 1;
  color: #fff;
`;

const TeamNamesWrapper = styled.div`
  width:12rem;
  margin: 4.2rem 3rem 0 0;
  font-size: 2rem;
  line-height: 3.7rem;
  text-align: end;
`;

const ScoreTable = styled.table`
  width: 100%; 
  border-collapse:separate;
  border-spacing: 0.4rem 1rem;;
  & > tbody{
    box-shadow:0 -4px 2px -2px #fff
  }
  & tr{
    margin-bottom: 2rem;
  }
  & th, td{
    width: 3rem;
    text-align: center;
  }
  font-size: 2rem;
`;

const TeamName = styled.div`
  position:relative;
  width: max-content;
  margin-left: auto;
  ${({ player }) => player && css`
      &::after{
        content: 'Player';
        position: absolute;
        display: block;
        width: 100%;
        font-size: 0.9rem;
        color: red;
        top: 45%;
        font-weight: 700;
        text-align: center;
      }
  `}
`;


export default TopPopup;
