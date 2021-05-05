import { useState } from "react";
import styled from "styled-components";

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
const Table = styled.div`
	position: absolute;
	border: 1px solid red;
	display: flex;
	justify-content: center;
	align-items: center;
	width: 1100px;
	height: 180px;
	top: ${(props) => (props.slide ? "20px" : "-200px")};
	left: 90px;
	transition: 400ms;
	z-index: 2;
`;


export default ScoreBoard;
