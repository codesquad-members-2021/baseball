import styled from 'styled-components'

const RoundTitle = () => {
  const round = new Array(13)
    .fill('')
    .map((v, i) =>
      i === 12 ? <RoundSpan>R</RoundSpan> : <RoundSpan>{i+1}</RoundSpan>
    )

  return <RoundWarpper>{round}</RoundWarpper>
}

export default RoundTitle

const RoundWarpper = styled.div`
  display: flex;
  border-bottom: 0.3rem white solid;
`

const RoundSpan = styled.span`
  color: white;
  font-size: 2rem;
  margin: 0 1rem;
  font-weight: 700;
`
