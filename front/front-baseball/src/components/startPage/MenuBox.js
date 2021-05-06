import { useEffect, useState, useRef } from "react";
import styled, { css } from "styled-components";
import { MESSAGE } from "../../utils/constant.js";
import Game from "./Game";
const MenuBox = () => {
  const [games, setGames] = useState([1, 2, 3]);
  const scrollHeight = useRef(0);
  useEffect(() => {
    const fetchGamesDate = async () => {
      const newGames = await dummyFetch();
      setGames((games) => [...games, ...newGames]);
    };
    if (games.length < 10) fetchGamesDate();
  });
  return (
    <MenuWrapper>
      <MessageBox>{MESSAGE.INIT}</MessageBox>
      <Games>
        {games.map((el) => (
          <Game />
        ))}
      </Games>
    </MenuWrapper>
  );
};

const dummyFetch = () => {
  const data = {
    games: [
      {
        gameId: 1,
        home: {
          teamId: "team-1",
          teamName: "Captin",
          selected: false,
        },
        away: {
          teamId: "team-2",
          teamName: "Mavel",
          selected: true,
        },
      },
      {
        gameId: 2,
        home: {
          teamId: "team-3",
          teamName: "Twins",
          selected: false,
        },
        away: {
          teamId: "team-4",
          teamName: "Tigers",
          selected: true,
        },
      },
      {
        gameId: 3,
        home: {
          teamId: "team-5",
          teamName: "Rockets",
          selected: false,
        },
        away: {
          teamId: "team-6",
          teamName: "Dodgers",
          selected: true,
        },
      },
    ],
  };

  return new Promise((resolve) => {
    setTimeout(() => {
      resolve(data.games);
    }, 3000);
  });
};
const MenuWrapper = styled.div`
  margin-top: 1rem;
  width: 30%;
`;
const MessageBox = styled.div`
  text-align: center;
  color: white;
  margin: 3rem 0;
  font-size: 2rem;
`;
const Games = styled.div`
  height: 500px;
  display: flex;
  flex-direction: column;
  overflow: scroll;
  -ms-overflow-style: none;
  scrollbar-width: none;
  &::-webkit-scrollbar {
    display: none;
  }
`;
export default MenuBox;
