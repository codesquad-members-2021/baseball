import styled from "styled-components";
import Score from "./Score";
import Field from "./Field";

const Ground = () => {
	const data = {
		homeTeam: {
			name: "Eagles",
			score: 1,
		},
		awayTeam: {
			name: "Bears",
			score: 14,
		},
	};
	return (
		<StyledGround>
			<Score {...data} />
			<Field />
		</StyledGround>
	);
};

const StyledGround = styled.div`
	width: 960px;
	height: 720px;
	border-right: 3px solid gray;
`;

export default Ground;
