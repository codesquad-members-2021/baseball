import React from 'react';
import styled from 'styled-components';

const PopUp = ({ children }) => {
  return <StylePopUp>{children}</StylePopUp>;
};

const StylePopUp = styled.div`
  position: absolute;
  top: 0;
  width: 100vw;
  height: 100vh;
  z-index: 0;
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
`;

export default PopUp;

// const PopUp = ({ children }) => {
//   return <StylePopUp>{children}</StylePopUp>;
// };

// const StylePopUp = styled.div`
//   position: fixed;
//   width: 100vw;
//   height: 100vh;
//   background-color: rgba(0, 0, 0, 0.4);
// `;
