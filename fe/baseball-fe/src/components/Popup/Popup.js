import { useState } from 'react';
import styled from 'styled-components';

function Popup({ direction, children }) {
    const [ active, setActive ] = useState(false);

    const closePopup = ({ target }) => {
        console.log(target)
        !target.closest('.wrapper') && setActive(false);
    }

    return (
        active
        ? <StlyedPopup onClick={(e)=> closePopup(e)}>
            <div className="wrapper">
                {children}
            </div>
        </StlyedPopup>
        : <StyleEmpty direction={direction} onMouseEnter={() => setActive(true)}/>
    )
}

export default Popup;

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

//마우스 오버 이벤트: 보이지 않는 div 상자를 만들어두고, mouseover가 되었을 때 Slide 되어서 내려올 수 있게 하기!
//bottom popup과 top popup에 모두 재사용이 가능하게 만들기!