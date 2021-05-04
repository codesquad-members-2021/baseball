import styled from 'styled-components';

const MatchBox = () => {
  return <MatchBoxStyle>MatchBox</MatchBoxStyle>;
};

export default MatchBox;

const MatchBoxStyle = styled.div`
  border: 1px solid #fff;
  border-radius: 10px;
  margin: 10px;
  width: 100%;
  height: 100px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
`;
