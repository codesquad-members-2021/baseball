import { useState } from "react";
import styled from "styled-components";
import Table from "./Table";

const ScoreBoard = ({ slide, toggle, setDark }) => {
	return (
		<StyledScoreBoard>
			<NearChecker
				onMouseEnter={() => {
					toggle(true);
					setDark(true);
				}}
			/>
			<Table slide={slide} />
		</StyledScoreBoard>
	);
};
const StyledScoreBoard = styled.div``;
const NearChecker = styled.div`
	position: absolute;
	width: 1280px;
	height: 100px;
`;

export default ScoreBoard;
