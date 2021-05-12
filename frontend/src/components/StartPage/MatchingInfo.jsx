import styled from 'styled-components';
import { useHistory } from 'react-router-dom';
import API from '../Hook/API';
import { theme } from '../Style/Theme';
import { useState, useEffect } from 'react';

const MatchingInfo = ({ setMessage, data }) => {
  const [currentID, setID] = useState(null);
  const [currentType, setType] = useState(null);

  useEffect(() => {
    const getResponse = async () => {
      if (!currentID) return;
      // const foo = await API.patch.initGame(currentID);
      // console.log(foo);
      const response = await fetch(
        `http://13.124.70.38:8080/games/${currentID}`,
        {
          method: 'PATCH',
          headers: {
            'Content-Type': 'application/json',
            'API-Key': 'secret',
          },
        }
      );
      const status = response.status;
      if (status === 200 && currentType === 'HOME') {
        history.push(`/defense/${currentID}`);
      } else if (status === 200 && currentType === 'AWAY') {
        history.push(`/attack/${currentID}`);
      } else if (status === 409) {
        setMessage(`이미 게임이 시작되었습니다. \n다른 팀을 선택해주세요`);
        //occupied=true인경우(409error)
      }
    };
    getResponse();
  }, [currentID, currentType]);

  const history = useHistory();

  const handleClick = (id, type) => {
    setID(id);
    setType(type);
  };

  const TeamStatus = () => {
    return (
      <>
        <TeamName
          className={data.occupied ? 'occupied' : ''}
          onClick={() => {
            handleClick(data.id, 'AWAY');
          }}
        >
          {data.awayTeam.teamName}
        </TeamName>
        <VS>VS</VS>
        <TeamName
          className={data.occupied ? 'occupied' : ''}
          onClick={() => handleClick(data.id, 'HOME')}
        >
          {data.homeTeam.teamName}
        </TeamName>
      </>
    );
  };

  return (
    <TeamWrapper>
      <TeamStatus />
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

  &.occupied {
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
