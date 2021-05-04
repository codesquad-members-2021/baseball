import styled from 'styled-components';
import MatchBox from './MatchBox/MatchBox';

const MatchInfoBody = () => {
  return (
    <ScrollMask>
      <MatchInfoBodyStyle>
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
        <MatchBox />
      </MatchInfoBodyStyle>
    </ScrollMask>
  );
};

export default MatchInfoBody;

const MatchInfoBodyStyle = styled.div`
  width: 100%;
  height: 500px;
  padding: 0px 20px 0px 10px;
  overflow-y: scroll;

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

  mask-image: linear-gradient(to top, transparent, #222),
    linear-gradient(to left, transparent 12px, #222 12px);
  mask-size: 100% 2000000px;
  mask-position: left bottom;
  transition: mask-position 0.3s, -webkit-mask-position 0.3s;

  :hover {
    mask-position: left top;
  }
`;

const ScrollMask = styled.div`
  width: 100%;
  height: 502px;
  border: 1px solid #ffa7c4;
`;
