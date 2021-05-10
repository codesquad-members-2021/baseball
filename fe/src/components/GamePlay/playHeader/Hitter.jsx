const Hitter = ({ hitter }) => {
  // 이 부분은 reducer로 만드는게 좋을 것 같다.
  return (
    <>
      <span>류현진</span>
      <span>
        {hitter.turn}타석 {hitter.hit}안타
      </span>
    </>
  );
};

export default Hitter;
