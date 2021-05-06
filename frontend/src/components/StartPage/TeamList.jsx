import React, { useState, useEffect } from 'react';
import styled from 'styled-components';
import API from '../Hook/API';
import { theme } from '../Style/Theme';

const SingleList = styled.div`
  width: 337px;
  height: 85px;
  margin: 10px;

  background: #c4c4c4;
  border-radius: 12px;
`;

const GameTitle = styled.div`
  font-size: ${theme.fontSize.small};
  font-weight: ${theme.fontWeight.normal};
  color: ${theme.colors.red};
`;

const TeamName = styled.span`
  font-size: ${theme.fontSize.large};
  font-weight: ${theme.fontWeight.bold};
  color: ${theme.colors.black};
`;

const TeamList = () => {
  const [teamList, setTeamLiset] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState('');

  useEffect(() => {
    const getGameList = async () => {
      setLoading(true);
      try {
        const { games } = await API.get.teamList();
        console.log(games);
        setTeamLiset(games);
        setLoading(false);
      } catch (err) {
        setError(err); //error처리
      }
    };
    getGameList();
  }, []);

  const List = () => {
    return teamList.map((team, i) => (
      <SingleList key={i}>
        <di>{team.gameTitle}</di>
        <GameTitle>
          <TeamName>{team.awayTeam.teamName}</TeamName>
          <span>VS</span>
          <TeamName>{team.homeTeam.teamName}</TeamName>
        </GameTitle>
      </SingleList>
    ));
  };

  return (
    <>
      {error && <div>에러가 발생했습니다 : {error}</div>}
      {loading ? <div>Loading...</div> : <List />}
    </>
  );
};

export default TeamList;
