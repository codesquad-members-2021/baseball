import styled from "styled-components";
<<<<<<< HEAD
import Header from "./Header";
import Main from "./Main"
=======
import Score from "./Score";
import Field from "./Field"
>>>>>>> 1e3645475e93f1fb9d1a80dcb58913934e539724

const Ground = () => {
	return (
		<StyledGround>
<<<<<<< HEAD
			<Header />
			<Main />
=======
			<Score />
			<Field />
>>>>>>> 1e3645475e93f1fb9d1a80dcb58913934e539724
		</StyledGround>
	);
};

const StyledGround = styled.div`
	width: 960px;
	height: 720px;
	border-right: 3px solid gray;
`;

export default Ground;
