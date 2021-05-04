import styled from 'styled-components';

const TeamName = () => {
  return <TeamNameStyle>TeamName</TeamNameStyle>;
};

export default TeamName;

const TeamNameStyle = styled.div`
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 23px;
  font-weight: 900;
  cursor: pointer;
  transition: all ease-in-out 0.2s;

  :hover {
    color: #ffa7c4;
    font-size: 24px;
  }
`;
