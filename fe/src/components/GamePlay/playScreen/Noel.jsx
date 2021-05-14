import styled, { keyframes } from 'styled-components';

const Noel = ({ idx }) => {
  return <Base idx={idx} src="noel.png" />;
};

export default Noel;

const noelMove1 = keyframes`
0%{
  transform: translate3d(0,0,0) scale(1.1);
}
50%{
  transform: scale(1.3) translate3d(115px, -100px, 0);
}
100%{
  transform: translate3d(230px, -200px, 0) scale(1.0)
}
`;

const noelMove2 = keyframes`
0%{
  transform: translate3d(230px,-200px,0) scale(1.1);
}
50%{
  transform:
}
100%{
  transform: translate3d(0, -400px, 0) scale(1.0)
}
`;
const noelMove3 = keyframes`
0%{
  transform: translate3d(0px,-400px,0) scale(1.1);
}
50%{
  transform: 
}
100%{
  transform: translate3d(-230px, -200px, 0) scale(1.0)
}
`;
const noelMove4 = keyframes`
0%{
  transform: translate3d(230px,-200px,0) scale(1.1);
}
50%{
  transform:
}
100%{
  transform: translate3d(0, 0, 0) scale(1.0);
}
`;

const Base = styled.img`
  position: absolute;
  z-index: 9999;
  width: 80px;
  bottom: 20%;
  animation: ${(props) => {
      switch (props.idx) {
        case 0:
          return noelMove1;
        case 1:
          return noelMove2;
        case 2:
          return noelMove3;
        case 3:
          return noelMove4;
        default:
      }
    }}
    2s linear;
  animation-fill-mode: forwards;
`;

/* transform: translate3d(230px, -200px, 0); // 1루 */
/* transform: translate3d(0, -400px, 0); // 2루 */
/* transform: translate3d(-230px, -200px, 0); // 3루 */
/* transform: translate3d(0, 0, 0); // home */

// ${(props) => {
//   switch (props.idx) {
//     case 0:
//       return noelMove1;
//     case 1:
//       return noelMove2;
//     case 2:
//       return noelMove3;
//     case 3:
//       return noelMove4;
//     default:
//   }
// }};
