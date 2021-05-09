import styled from "styled-components";
import Score from "./Score";
import Field from "./Field"

const Ground = () => {
	return (
		<StyledGround>
			<Score />
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
