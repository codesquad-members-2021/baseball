import { useContext } from 'react';
import styled, { keyframes } from 'styled-components';
import { IoIosBaseball } from 'react-icons/io';

import { gamePlayContext } from 'pages/Game';
import BallCount from 'components/GamePlay/playScreen/BallCount';

const Screen = () => {
  const { dispatchBallCount } = useContext(gamePlayContext);

  const chooseNumber = () => Math.floor(Math.random() * 4);

  const getAction = (number) => {
    return {
      0: 'strike',
      1: 'ball',
      2: 'out',
      3: 'hit',
    }[number];
  };

  const handleClickPitch = () => {
    const action = getAction(chooseNumber());
    dispatchBallCount({ payload: action });
  };

  return (
    <StyledScreen>
      <ScreenField src="field.svg" alt="field" />
      <ScreenRound>2회 초 수비</ScreenRound>
      <PitchButton onClick={handleClickPitch}>
        <IoIosBaseball />
      </PitchButton>
      <BallCount />
    </StyledScreen>
  );
};

export default Screen;

const StyledScreen = styled.section`
  display: flex;
  justify-content: center;
  align-items: center;
  width: 80%;
  height: 100%;
  background-image: linear-gradient(rgba(0, 0, 0, 0.7), rgba(0, 0, 0, 0.7)),
    url('https://upload.wikimedia.org/wikipedia/commons/8/80/Munhak_baseball_stadium_2012.png');
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
`;

const ScreenField = styled.img`
  height: fit-content;
  width: 27%;
  transform: rotate(45deg);
`;
const ScreenRound = styled.span`
  font-size: ${({ theme }) => `${theme.fontSizes.BASE}rem`};
  font-weight: ${({ theme }) => `${theme.weights.BASE}`};
  color: ${({ theme }) => `${theme.colors.white}`};
  position: absolute;
  right: 2%;
  top: 4%;
`;
const rotateAnimation = keyframes`
0%{
  transform: rotate(0deg) scale(1);
}
50%{
  transform: rotate(180deg) scale(1.5);
}
100%{
  transform: rotate(360deg) scale(1);
}
`;

const PitchButton = styled.button`
  height: 5rem;
  position: absolute;
  left: 50%;
  top: 50%;
  cursor: pointer;
  font-size: 5rem;
  color: white;
  background: none;
  transform: translate(-50%, -50%);

  &:hover {
    svg {
      animation: ${rotateAnimation} 4s linear infinite;
    }
  }
`;
