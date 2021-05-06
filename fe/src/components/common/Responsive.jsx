import styled from "styled-components";

const Responsive = ({ children, ...rest }) => {
  // style, className, onClick, onMouseMove 등의 props를 사용할 수 있도록
  // …rest를 사용하여 ResponsiveBlock에게 전달
  return <ResponsiveBlock {...rest}>{children}</ResponsiveBlock>;
};

const ResponsiveBlock = styled.div`
  max-width: 1440px;
  height: 100vh;
  padding: 0 80px;
  margin: 0 auto; /* 중앙 정렬 */
  box-sizing: border-box;

  /* 브라우저 크기에 따라 가로 크기 변경 */
  @media (max-width: 1024px) {
    // 브라우저가 1024미만일때 안에 내용물이 768
    width: 768px;
    padding: 0 60px;
  }
  @media (max-width: 768px) {
    // 브라우저가 768 미만일때 안에 내용물이 332
    width: 100%;
    padding: 0 50px;
  }
`;

export default Responsive;
