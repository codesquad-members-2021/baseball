import ScoreTable from './ScoreTable/ScoreTable';
import { ScoreBoardStyles as S } from './ScoreBoardStyles';
import { useState } from 'react';
import PopUpButton from './PopUpButton';

const ScoreBoard = () => {
  const initialScoreBoardPosition = -199;
  const [isHover, setIsHover] = useState(false);
  const [scoreBoardPosition, setScoreBoardPosition] = useState(
    initialScoreBoardPosition
  );

  const handleMouseEnter = () => {
    setIsHover((prev) => !prev);
    setScoreBoardPosition(-3);
  };

  const handleMouseLeave = () => {
    setIsHover((prev) => !prev);
    setScoreBoardPosition(initialScoreBoardPosition);
  };

  return (
    <>
      <S.PopUpBackground isHover={isHover} />
      <S.ScoreBoard
        isHover={isHover}
        scoreBoardPosition={scoreBoardPosition}
        onMouseEnter={handleMouseEnter}
        onMouseLeave={handleMouseLeave}
      >
        <ScoreTable />
        <PopUpButton {...{ isHover }} />
      </S.ScoreBoard>
    </>
  );
};

export default ScoreBoard;
