import TeamName from 'components/GameHome/TeamName'
import styled, { css } from 'styled-components'
import { Link } from 'react-router-dom'
import Span from 'components/common/Span'
import FlexCenter from 'styles/FlexCenter'

const GameSelect = () => {
  return (
    <SelectContainer>
      <TeamName type={'home'}/>
      <FlexCenter>
        <Span size={2}>vs</Span>
      </FlexCenter>
      <TeamName type={'away'}/>
    </SelectContainer>
  )
}

export default GameSelect

const SelectContainer = styled(FlexCenter)`
  width: 100%;
  justify-content: center;
`