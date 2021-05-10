import { useContext, useState } from "react";
import styled from "styled-components";
import ScoreBoard from "./ScoreBoard/ScoreBoard";
import LineUp from "./LineUp/LineUp";
import Ground from "./Ground/Ground";
import Record from "./Record/Record";
import { MainContext } from "../../App";

const InGame = () => {
	const { gameId } = useContext(MainContext);

	const [slideScoreBoard, toggleScoreBoard] = useState(false);
	const [slideLineUp, toggleLineUp] = useState(false);
	const [isDark, setDark] = useState(false);
	const clickMain = () => {
		toggleScoreBoard(false);
		toggleLineUp(false);
		setDark(false);
	};
	return (
		<StyledInGame>
			<ScoreBoard slide={slideScoreBoard} toggle={toggleScoreBoard} isDark={isDark} setDark={setDark} gameId={gameId} />
			<LineUp slide={slideLineUp} toggle={toggleLineUp} isDark={isDark} setDark={setDark} gameId={gameId} />
			<Main onClick={clickMain} isDark={isDark}>
				<Ground gameId={gameId} />
				<Record gameId={gameId} />
			</Main>
		</StyledInGame>
	);
};

export default InGame;

const StyledInGame = styled.div`
	position: relative;
	overflow: hidden;
	margin-top: 30px;
`;
const Main = styled.div`
	height: 720px;
	filter: ${({ isDark }) => (isDark ? "brightness(20%)" : "")};
	transition: filter 400ms;

	font-size: 5rem;
	color: white;
`;
