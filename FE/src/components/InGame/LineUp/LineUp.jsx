import { useState } from "react";
import styled from "styled-components";
import Table from "./Table";

const LineUp = ({ gameId, slide, toggle, isDark, setDark }) => {
	const [data, setData] = useState();
	const fetchData = async () => {
		try {
			const response = await fetch(`https://baseball-ahpuh.herokuapp.com/games/${gameId}/lineup`);
			const json = await response.json();
			setData(() => json);
		} catch (error) {
			console.log("fetch error in LineUp : ", error);
		}
	};
	const slideLineUp = async () => {
		if (isDark) return;
		await fetchData();
		toggle(true);
		setDark(true);
	};
	return (
		<StyledLineUp>
			<NearChecker onMouseEnter={slideLineUp} />
			<Table slide={slide} data={data} />
		</StyledLineUp>
	);
};
const StyledLineUp = styled.div``;
const NearChecker = styled.div`
	position: absolute;
	width: 1280px;
	height: 40px;
	top: 680px;
`;

export default LineUp;
