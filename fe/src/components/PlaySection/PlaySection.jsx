import styled from "styled-components";
import { useReducer } from "react";
import PlayInning from "./PlayInning";
import PlayPitch from "./PlayPitch";
import PlaySBOInfo from "./PlaySBOInfo";
import PlayField from "./PlayField";

const initialSBOState = {
  strike: 0,
  ball: 0,
  out: 0,
};

const SBOReducer = (state, action) => {
  switch (action.type) {
    case "STRIKE":
      return { ...state, strike: state.strike + 1 };
    case "BALL":
      return { ...state, ball: state.ball + 1 };
    case "OUT":
      return { ...state, out: state.out + 1 };
    case "SB_RESET":
      return { ...state, strike: 0, ball: 0 };
    case "TOTAL_RESET":
      return { ...initialSBOState };
    default:
      throw new Error(`Unhandled action type: ${action.type}`);
  }
};

const PlaySection = () => {
  const [SBOState, dispatch] = useReducer(SBOReducer, initialSBOState);

  return (
    <PlaySectionLayout>
      <PlaySBOInfo SBOState={SBOState} />
      <PlayField />
      <PlayPitch {...{ SBOState, dispatch }} />
      <PlayInning></PlayInning>
      <PlayBackgroundLayer>
        <PlayBlackLayer />
      </PlayBackgroundLayer>
    </PlaySectionLayout>
  );
};

const PlaySectionLayout = styled.div`
  width: 100%;
  height: 100%;
  position: absolute;
`;

const PlayBackgroundLayer = styled.div`
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;
  z-index: -1;

  background-image: url("https://i2.wp.com/beechumcounty.com/wp-content/uploads/2018/01/Messages-Image2796961593.jpeg?fit=1400%2C889&ssl=1");
  background-size: cover;
`;

const PlayBlackLayer = styled.div`
  width: 100%;
  height: 100%;
  position: absolute;
  top: 0;

  background-color: black;
  opacity: 70%;
`;

export default PlaySection;
