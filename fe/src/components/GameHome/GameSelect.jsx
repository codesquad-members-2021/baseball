import TeamName from 'components/GameHome/TeamName';
import styled from 'styled-components';
import VsSpan from 'components/common/VsSpan';
import FlexCenter from 'styles/FlexCenter';

const GameSelect = () => {
  return (
    <SelectContainer>
      <TeamName type={'home'} />
      <FlexCenter>
        <VsSpan>vs</VsSpan>
      </FlexCenter>
      <TeamName type={'away'} />
    </SelectContainer>
  );
};

export default GameSelect;

const SelectContainer = styled(FlexCenter)`
  width: 100%;
  justify-content: center;
`;
