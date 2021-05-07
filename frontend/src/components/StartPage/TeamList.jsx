import React, { useState, useEffect, useCallback } from 'react';
import styled from 'styled-components';
import { theme } from '../Style/Theme';
import { Link, useHistory } from 'react-router-dom';
import useFetch from '../Hook/useFetch';

const TeamList = props => {
  const [teamData, loadingTeamData, error1] = useFetch('get', 'teamList');
  const teamListData = teamData.games;

  const [currentID, setID] = useState(null);
  const [occupiedState, loadingOccupiedState, error2] = useFetch(
    'patch',
    'initData',
    currentID
  );
  const history = useHistory();

  const onClick = useCallback(
    async id => {
      await setID(id);
      if (!error2) {
        history.push(`/defense/${id}`);
      }
    },
    [history]
  );

  const Lists = () => {
    return teamListData.map((team, i) => (
      <SingleList key={i}>
        <GameTitle>{team.gameTitle}</GameTitle>
        <TeamWrapper>
          <TeamName id={team.id}>{team.awayTeam.teamName}</TeamName>
          <span>VS</span>
          <TeamName
            onClick={() => {
              onClick(team.id);
            }}
          >
            {team.homeTeam.teamName}
          </TeamName>
        </TeamWrapper>
      </SingleList>
    ));
  };

  return !loadingTeamData && <Lists />;
};

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
  padding-top: 5px;

  text-align: center;
`;

const TeamName = styled.span`
  font-size: ${theme.fontSize.large};
  font-weight: ${theme.fontWeight.bold};
  color: ${theme.colors.black};
  cursor: pointer;

  &:hover {
    color: ${theme.colors.red};
  }
`;

const TeamWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-between;
  overflow: hidden;
  height: 55px;
  padding: 0 30px;
`;

export default TeamList;
