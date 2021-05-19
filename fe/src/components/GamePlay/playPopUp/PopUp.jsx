import styled from 'styled-components'

const PopUp = ({ children, type }) => {
  return <StyledPopUp {...{ type }}>{children}</StyledPopUp>
}
export default PopUp

const StyledPopUp = styled.section`
  position: fixed;
  z-index: 9999;
  width: 100%;
  height: 100%;
  top: ${({ type }) => (type === 'up' ? '-95%' : '95%')};
  transition: .5s ease-out;
  background-color: rgba(0, 0, 0, 0.8);
  opacity: 0;
  &:hover {
    top: 0;
    opacity: 1;
  }
  &:active {
    transition: none;
    top: ${({ type }) => (type === 'up' ? '-95%' : '95%')};
    opacity: 0;
  }
`
