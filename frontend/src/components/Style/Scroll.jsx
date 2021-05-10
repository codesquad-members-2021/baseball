import styled from 'styled-components/';
import { theme } from '../Style/Theme';
const Scroll = styled.div`
	padding-right: 10px;
	overflow: hidden;
	box-sizing: border-box;
	&:hover {
		overflow-y: scroll;
	}
	&::-webkit-scrollbar {
		width: 10px;
		padding-right: 5px;
	}
	&::-webkit-scrollbar-thumb {
		background-color: ${theme.colors.red_log};
		border-radius: 5px;
	}
	&::-webkit-scrollbar-track {
		background-color: ${theme.colors.grey_transparent};
		border-radius: 5px;
	}
`;
//scroll 위치 조정하기, 가로 x scroll방지
export default Scroll;
