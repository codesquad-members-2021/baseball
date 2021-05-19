import styled from 'styled-components'
import PopUp from './PopUp'
import RoundTitle from './RoundTitle'
const Round = () => {
  return (
    <PopUp type='up'>
      <RoundWrapper>
        <RoundTitle />
      </RoundWrapper>
    </PopUp>
  )
}

export default Round

const RoundWrapper = styled.div`
  border: 0.3rem white solid;
  display: flex;
`
// const RoundTitle = styled.div``

const RoundContentTitle = styled.div``
