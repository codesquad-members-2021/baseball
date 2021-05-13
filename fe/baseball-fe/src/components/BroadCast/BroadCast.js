import styled from 'styled-components';
import { useRef, useState, useEffect } from 'react';

import BatterRecordList from './BatterRecordList.js';

function BroadCast({ className }) {
  const [scrollWidth, setScrollWidth] = useState();
  const [mouseOver, setMouseOver] = useState(false);
  const ref = useRef();

  useEffect(() => {
    if (mouseOver === false || scrollWidth)
      return;

    setScrollWidth(ref.current.offsetWidth - ref.current.clientWidth);
  }, [mouseOver]);

  const handleMouseOver = () => {
    setMouseOver(true);
  }

  const handleMouseEnter = () => {
    setMouseOver(true);
  }

  const handleMouseLeave = () => {
    setMouseOver(false);
  }

  return (
    <StyledBroadCast
      className={className} 
      ref={ref}
      mouseOver={mouseOver}
      scrollWidth={mouseOver ? scrollWidth : 0}
      onMouseOver={handleMouseOver}
      onMouseEnter={handleMouseEnter}
      onMouseLeave={handleMouseLeave}>
      <BatterRecordList/>
    </StyledBroadCast>
  )
}

export default BroadCast;

const StyledBroadCast = styled.div`
  box-shadow: 0 0 0 1px black inset;
  background-color: black;
  margin-right: ${props => '-' + String(props.scrollWidth) + 'px'};
  overflow-y: ${props => props.mouseOver ? 'scroll' : 'hidden'};
`;