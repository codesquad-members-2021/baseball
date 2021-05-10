import { useState } from 'react';
import styled, { keyframes } from 'styled-components';

function Popup({ direction, children }) {
    const [ active, setActive ] = useState(false);

    const closePopup = ({ target }) => {
        console.log(target)
        !target.closest('.wrapper') && setActive(false);
    }

    return (
        active
        ? <StlyedPopup direction={direction} onClick={(e)=> closePopup(e)}>
            <div className="wrapper">
                {children}
            </div>
        </StlyedPopup>
        : <StyleEmpty direction={direction} onMouseEnter={() => setActive(true)}/>
    )
}

export default Popup;

const drop = keyframes`
    0% {
        top: 20%;
    }
    100% {
        top: 50%;
    }
`;

const raise = keyframes`
    0% {
        top: 60%;
    }
    100% {
        top: 50%;
    }
`;


//팝업의 배경이 되는 요소
const StlyedPopup = styled.div`
position: absolute;
top: 0;
width: 100%;
background-color: black;
opacity: 0.9;
height: 100%;
z-index: 1;

//child요소들의 wrapper
.wrapper {
    border: 1px solid blue;
    width: 80%;
    position: absolute;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    animation: ${props => props.direction === "top" ? drop : raise} 0.5s cubic-bezier(0.61, 1, 0.88, 1);
}
`

const StyleEmpty = styled.div`
  display: block;
  height: 5rem;
  width: 100%;
  position: absolute;
  top: ${props => props.direction === "top" && "0px"};
  bottom: ${props => props.direction === "bottom" && "0px"};
`
