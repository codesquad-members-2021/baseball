import React from 'react';
import styled from 'styled-components';


const Screen = (props) => {
  return (
    <StyleScreen>
      <StylePitch>PITCH</StylePitch>
      <StyleGround>
        <div className="base home">
        </div>
        <div className="base"></div>
        <div className="base"></div>
        <div className="base"></div>
      </StyleGround>
    </StyleScreen>
  );
}

const StyleScreen = styled.div`
  position:relative;
  align-self: center;
`;
const StylePitch = styled.button`
  position: absolute;
  top: calc(50% - 1.5rem);
  left: calc(50% - 5rem);
  display: inline;
  width: 10rem;
  height: 3rem;
  font-size: 2rem;
  font-weight: 600;
  border: 2px solid #fff;
  border-radius: 0.5rem;
  background: transparent;
  color: #fff;
  cursor: pointer;
  transition: all 0.1s linear;
  z-index: 1;
  &:hover {
    background-color: #fff;
    color:#000;
  }
`

const StyleGround = styled.div`
  border: 3px solid #fff;
  width: 20rem;
  height: 20rem;
  margin: auto;
  position: relative;
  transform: rotate(-45deg);
  .base {
    position: absolute;
    background-color: #fff;
    width: 2rem;
    height: 2rem;
    &:nth-child(1) {
      bottom: -1rem;
      left: -1rem;
      &:before {
        content: "";
        background-color: #fff;
        width: 2.8284712rem;
        height: 4rem;
        position: absolute;
        bottom: -2.45rem;
        left: -1.88rem;
        transform: rotate(45deg);
      }
    }
    &:nth-child(2) {
      bottom: -1rem;
      right: -1rem;
    }
    &:nth-child(3) {
      top: -1rem;
      right: -1rem;
    }
    &:nth-child(4) {
      top:-1rem;;
      left:-1rem;
    }
  }
`

export default Screen;