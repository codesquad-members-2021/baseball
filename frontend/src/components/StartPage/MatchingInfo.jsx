import styled from 'styled-components';
import { useHistory } from 'react-router-dom';
import useFetch from '../Hook/useFetch';
import { theme } from '../Style/Theme';
import { useState, useEffect, useCallback } from 'react';

const MatchingInfo = ({ setMessage, data }) => {
  const [currentID, setID] = useState(null);
  const [occupiedState, loadingOccupiedState, occupied] = useFetch(
    'patch',
    'initGame',
    currentID
  );

  const history = useHistory();

  const handleClick = (id, type) => {
    // setID(id);
    if (occupied && type === 'HOME') {
      history.push(`/defense/${id}`);
    } else if (occupied && type === 'AWAY') {
      history.push(`/attack/${id}`);
    } else {
      setMessage(`이미 게임이 시작되었습니다. \n다른 팀을 선택해주세요`);
      //occupied=true인경우(409error)
    }
  };

  const TeamStatus = occupied => {
    return (
      <>
        <TeamName
          className={occupied ? 'occupied' : ''}
          onClick={() => {
            handleClick(data.id, 'AWAY');
          }}
        >
          {data.awayTeam.teamName}
        </TeamName>
        <VS>VS</VS>
        <TeamName
          className={occupied ? 'occupied' : ''}
          onClick={() => handleClick(data.id, 'HOME')}
        >
          {data.homeTeam.teamName}
        </TeamName>
      </>
    );
  };

  return (
    <TeamWrapper>
      {data.occupied ? <TeamStatus occupied /> : <TeamStatus />}
    </TeamWrapper>
  );
};
const VS = styled.div`
  font-size: ${theme.fontSize.large};
  font-weight: ${theme.fontWeight.bold};
  color: ${theme.colors.grey_deep};
`;
const TeamName = styled.span`
  font-size: ${theme.fontSize.X_large};
  font-weight: ${theme.fontWeight.bold};
  cursor: pointer;
  &:hover {
    color: ${theme.colors.red};
  }

  .occupied {
    pointer-events: none;
    color: ${theme.colors.grey_deep};
  }
`;
const TeamWrapper = styled.div`
  display: flex;
  align-items: center;
  justify-content: space-around;
  padding: 0 30px;
`;

export default MatchingInfo;
