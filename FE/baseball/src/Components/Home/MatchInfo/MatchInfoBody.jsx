import styled from 'styled-components';
import MatchBox from './MatchBox/MatchBox';

const MatchInfoBody = () => {
  return (
    <MatchInfoBodyStyle>
      <MatchBox />
      <MatchBox />
      <MatchBox />
      <MatchBox />
      <MatchBox />
      <MatchBox />
      <MatchBox />
    </MatchInfoBodyStyle>
  );
};

export default MatchInfoBody;

const MatchInfoBodyStyle = styled.div`
  width: 100%;
  height: 500px;
  border: 1px solid #ffa7c4;
  padding: 0px 20px 0px 0px;
  overflow: scroll;
  overflow-x: hidden;

  ::-webkit-scrollbar {
    width: 10px;
    height: 20px;
  }

  ::-webkit-scrollbar-track {
    background-color: #222;
    border-radius: 8px;
  }

  ::-webkit-scrollbar-thumb {
    border-radius: 8px;
    background: #ffd2e1;
  }
`;
