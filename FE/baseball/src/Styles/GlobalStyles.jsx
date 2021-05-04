import { createGlobalStyle } from "styled-components";
import reset from "styled-reset";

const GlobalStyles = createGlobalStyle`
	${reset};
	a{
		text-decoration : none;
		color:inherit;
		cursor:pointer;
	}
	*{
		box-sizing:border-box;
	}
	body{
		color:#fff;
		font-family: 'Orbitron', sans-serif;
		font-size : 12px;
		background-color : rgba(20,20,20,1);
		padding-top:100px;
		display: flex;
		justify-content: center;
		align-items: center;
	}
	.App {
		width:1440px;
		height:1080px;
		display: flex;
		flex-direction:column;
		justify-content: center;
		align-items: center;
 }
`;

export default GlobalStyles;
