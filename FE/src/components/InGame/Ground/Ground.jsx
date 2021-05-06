import styled from "styled-components";
import Header from "./Header";
import Main from "./Main"

const Ground = () => {
	return (
		<StyledGround>
			<Header />
			<Main />
		</StyledGround>
	);
};

const StyledGround = styled.div`
	width: 960px;
	height: 720px;
	border-right: 3px solid gray;
`;

export default Ground;
