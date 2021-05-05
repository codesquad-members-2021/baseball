import { useEffect, useState } from "react";
import styled from "styled-components";
import Game from "./Game";

const TeamSelect = () => {
	const [gameList, setGameList] = useState([]);
	const [isHover, setHover] = useState(false);
	const [alertMessage, setAlertMessage] = useState("참가할 게임을 선택해주세요");
	useEffect(() => {
		fetch("https://baseball-ahpuh.herokuapp.com/games")
			.then((res) => res.json())
			.then((json) => setGameList(() => json))
			.catch((res) => console.log("loading error in TeamSelect : ", res));
	}, []);

	return (
		<Wrapper>
			<Alert>{alertMessage}</Alert>
			<GameList isHover={isHover} onMouseEnter={() => setHover(true)} onMouseLeave={() => setHover(false)}>
				{gameList ? gameList.map((el, i) => <Game {...el} key={i} index={i} />) : "loading..."}
			</GameList>
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
	position: relative;
	left: 15px;
	height: 386px;
	width: 745px;
	overflow-y: scroll;
	::-webkit-scrollbar {
		background-color: #a6a7ab;
		width: 13px;
		border-radius: 10px;
		display: ${(props) => (props.isHover ? "" : "none")};
	}
	::-webkit-scrollbar-thumb:vertical {
		background-color: #4c4c4c;
		border-radius: 10px;
		border: 2px solid transparent;
		background-clip: padding-box;
	}
`;

export default TeamSelect;
