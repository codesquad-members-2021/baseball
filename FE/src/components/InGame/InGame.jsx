import { useState } from "react";
import styled from "styled-components";
import ScoreBoard from "./ScoreBoard/ScoreBoard";

const InGame = () => {
	const [slideScoreBoard, toggleScoreBoard] = useState(false);
	const [isDark, setDark] = useState(false);
	const clickMain = () => {
		toggleScoreBoard(false);
		setDark(false);
	};
	return (
		<StyledInGame>
			<ScoreBoard slide={slideScoreBoard} toggle={toggleScoreBoard} setDark={setDark} />
			<Main onClick={clickMain} isDark={isDark}>
				김 수한무 거북이와 두루미
				<Ground />
				<Record />
			</Main>
			<LineUp />
		</StyledInGame>
	);
};

export default InGame;

const StyledInGame = styled.div`
	position: relative;
`;
const Main = styled.div`
	height: 720px;
	filter: ${({ isDark }) => (isDark ? "brightness(20%)" : "")};
	transition: 400ms;

	font-size: 5rem;
	color: white;
`;
const Ground = styled.div``;
const Record = styled.div``;
const LineUp = styled.div``;
