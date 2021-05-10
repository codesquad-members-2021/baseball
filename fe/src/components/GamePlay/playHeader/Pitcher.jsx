const Pitcher = ({ pitcher }) => {
  // 이 부분은 reducer로 만드는게 좋을 것 같다.
  return (
    <>
      <span>최동원</span>
      <span>#{pitcher.count}</span>
    </>
  );
};

export default Pitcher;
