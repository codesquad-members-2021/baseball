import { useEffect, useState } from "react";
import styled from "styled-components";
import Game from "./Game";

const TeamSelect = () => {
	const [gameList, setGameList] = useState([]);
	const [alertMessage, setAlertMessage] = useState("참가할 게임을 선택해주세요");
	useEffect(() => {
		fetch("https://baseball-ahpuh.herokuapp.com/games")
			.then((res) => res.json())
			.then((json) => setGameList(() => json))
			.catch((res) => console.log("loading error in TeamSelect : ", res));
	});

	return (
		<Wrapper>
			<Alert>{alertMessage}</Alert>
			<GameList>{gameList ? gameList.map((el, i) => <Game {...el} key={i} index={i} />) : "loading..."}</GameList>
		</Wrapper>
	);
};

const Wrapper = styled.div`
	height: 500px;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-evenly;
`;
const Alert = styled.div`
	color: #fff;
`;
const GameList = styled.ul`
	height: 400px;
	overflow-y: scroll;
	--ms-overflow-style: none;
	::-webkit-scrollbar {
		display: none;
	}
`;

export default TeamSelect;
