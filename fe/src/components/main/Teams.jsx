const Teams = ({ teamSet }) => {
  const tempFunction = (name, i) => {
    console.log(name);
    console.log(i === 0 ? "원정" : "홈");
  };
  return (
    <div>
      {teamSet.map((team, i) => (
        <button onClick={() => tempFunction(team.name, i)}>{team.name}</button>
      ))}
    </div>
  );
};

export default Teams;

// [
//   [
//     { id: 2, name: "Twins" },
//     { id: 5, name: "Tigers" },
//   ],
//   [
//     { id: 0, name: "Bears" },
//     { id: 7, name: "Dinos" },
//   ],
//   [
//     { id: 1, name: "Landers" },
//     { id: 3, name: "Giants" },
//   ],
//   [
//     { id: 4, name: "Eagles" },
//     { id: 6, name: "Lions" },
//   ],
// ];
