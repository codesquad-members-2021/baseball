const Hitter = ({ hitter }) => {
  return (
    <>
      <span>류현진</span>
      <span>
        {hitter.turn ?? 0}타석 {hitter.hit ?? 0}안타
      </span>
    </>
  );
};

export default Hitter;
