import styled from "styled-components";

const GameListItem = ({ game }) => {
  console.log(game);
  return <div>{game}</div>;
};

const GameListItemLayout = styled.div``;

export default GameListItem;
