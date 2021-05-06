import { useState, useRef, useCallback, useEffect } from "react";
import styled, { keyframes } from "styled-components";
import { MESSAGE } from "../../utils/constant.js";
import Game from "./Game";
import { useInfiniteScroll } from "../../utils/hooks.js";

const MenuBox = () => {
  const [games, setGames] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);
  const rootRef = useRef();
  const targetRef = useRef();

  const requestNewGames = useCallback(async () => {
    try {
      setLoading(true);
      const games = await dummyFetch();
      return games;
    } catch (e) {
      setError(e);
    } finally {
      setLoading(false);
    }
  }, []);

  const initLoad = useCallback(async () => {
    const newGames = await requestNewGames();
    setGames(newGames);
  }, [requestNewGames]);

  const loadMoreImage = useCallback(async () => {
    const newGames = await requestNewGames();
    setGames((games) => [...games, ...newGames]);
  }, [requestNewGames]);

  useInfiniteScroll({
    root: rootRef.current,
    target: targetRef.current,
    onIntersect: ([{ isIntersecting }]) => {
      if (isIntersecting && !loading) {
        loadMoreImage();
      }
    },
  });

  useEffect(() => {
    if (games.length < 1) {
      initLoad();
    }
  });

  return (
    <MenuWrapper>
      <MessageBox>{MESSAGE.INIT}</MessageBox>
      <GamesContainer>
        <Games ref={rootRef}>
          {games.map((el) => (
            <Game />
          ))}

          <div ref={targetRef}>{error && <ErrorView />}</div>
        </Games>
        {loading && (
          <LoadingView>
            <LoadingCircle />
          </LoadingView>
        )}
      </GamesContainer>
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
    }, 2000);
  });
};
const LoadingView = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  background: rgba(0, 0, 0, 0.4);
  font-size: 3rem;
  position: absolute;
  bottom: 0;
  width: 100%;
  height: 300px;
`;

const bounce = keyframes`
  0% {
    transform: rotate(0deg)
  }
  100% {
    transform: rotate(360deg)
  }
`;

const LoadingCircle = styled.div`
  background-color: transparent;
  border: 5px solid transparent;
  border-top: 5px solid rgba(189, 215, 60);
  width: 100px;
  height: 100px;
  border-radius: 100px;
  animation: ${bounce} 1s infinite linear;
`;
const ErrorView = styled.div``;
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
const GamesContainer = styled.div`
  position: relative;
`;
const Games = styled.div`
  height: 300px;
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
