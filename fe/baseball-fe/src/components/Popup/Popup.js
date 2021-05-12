import { useState, useEffect } from 'react';
import styled, { keyframes } from 'styled-components';
import { ReactComponent as Arrow } from 'rsc/arrow.svg'

function Popup({ direction, children }) {
    const [ active, setActive ] = useState(false);

    useEffect(() => {
        document.body.addEventListener('click', closePopup);
        return function cleanup(){
            window.removeEventListener('click', closePopup);
        }
    }, [])

    const closePopup = ({ target }) => {
        !target.closest('.wrapper') && setActive(false);
    }

    return (
        active
        ? <StlyedPopup direction={direction} onClick={(e)=> closePopup(e)}>
            <div className="wrapper">
                {children}
            </div>
        </StlyedPopup>
        : <StyleEmpty direction={direction} onMouseEnter={() => setActive(true)}>
            {direction === "top" ? "SCORE " : "PLAYERS "}
            <Arrow className="arrow" fill="#555"/>
        </StyleEmpty>
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
  color: #fff;
  text-align: center;
  font-weight:700;
  padding-top: 0.4rem;
  background-color: #95afc0;
  display: block;
  height: 2rem;
  width: 11%;
  position: absolute;
  top: ${props => props.direction === "top" && "0px"};
  bottom: ${props => props.direction === "bottom" && "0px"};
  left: ${props => props.direction === "top" ? "38rem" : "5rem"};

  .arrow {
    transform: ${props => props.direction === "top" ? "rotate(90deg)" : "rotate(270deg)"};
    height: 1rem;
    width: auto;
  }
`

