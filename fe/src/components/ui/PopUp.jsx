import React, {useState} from 'react';
import styled, { keyframes } from 'styled-components';

const PopUp = ({ children, position }) => {
  const [active, setActive] = useState(false);
  const handleClick = ({target}) => (target.className === 'childrenWrapper' || !target.closest('.childrenWrapper')) && setActive(false);
  return active ? <StyledPopUp onClick={handleClick} className={active ? 'active' : ''} position={position}>
    <div className='childrenWrapper'>
      {children}
    </div>
  </StyledPopUp> : <StyledEmpty position={position} onMouseEnter={() => setActive(true)} />;
};

const toBottom = keyframes`
0% {
  margin-top: -40rem;
}
100% {
  margin-top: 0rem;
}
`;

const toTop = keyframes`
0% {
  transform: translateY(30rem);
}
100% {
  transform: translateY(0rem);
}
`;

const StyledPopUp = styled.div`
  position: absolute;
  top: 0;
  width: 100vw;
  height: 100vh;
  z-index: 2;
  text-align: center;
  &:before {
    background-color: rgba(0, 0, 0, 0.9);
    content: '';
    position: absolute;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    z-index: -1;
  }
  &.active > * {
    animation: ${props => props.position === 'top' ? toBottom : toTop } 0.5s cubic-bezier(0.33, 1, 0.68, 1);
  }
`;

const StyledEmpty = styled.div`
  width:100vw;
  height:5rem;
  position: absolute;
  top: ${props => props.position === 'top' && '0px'};
  bottom: ${props => props.position === 'bottom' && '0px'};
`


export default PopUp;

// const PopUp = ({ children }) => {
//   return <StyledPopUp>{children}</StyledPopUp>;
// };

// const StyledPopUp = styled.div`
//   position: fixed;
//   width: 100vw;
//   height: 100vh;
//   background-color: rgba(0, 0, 0, 0.4);
// `;
