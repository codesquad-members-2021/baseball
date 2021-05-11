import { useState } from "react";
import styled from "styled-components";
import Table from "./Table";

const ScoreBoard = ({ gameId, slide, toggle, isDark, setDark }) => {
	const [data, setData] = useState({ awayTeam: { name: "", scores: [] }, homeTeam: { name: "", scores: [] } });
	const fetchData = async () => {
		try {
			const response = await fetch(`https://baseball-ahpuh.herokuapp.com/games/${gameId}/scores`);
			const json = await response.json();
			setData(() => json);
		} catch (error) {
			console.log("fetch error in ScoreBoard : ", error);
		}
	};
	const slideScoreBoard = async () => {
		if (isDark) return;
		await fetchData();
		toggle(true);
		setDark(true);
	};
	return (
		<StyledScoreBoard>
			<NearChecker onMouseEnter={slideScoreBoard} />
			<Table slide={slide} data={data} />
		</StyledScoreBoard>
	);
};
const StyledScoreBoard = styled.div``;
const NearChecker = styled.div`
	position: absolute;
	width: 1280px;
	height: 40px;
`;

export default ScoreBoard;
