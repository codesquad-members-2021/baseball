import styled from 'styled-components';
import { Span, theme } from '../Style/Theme';
const GameDetailScore = () => {
	return (
		<DetailWrapper>
			<Text>상세점수현황</Text>
		</DetailWrapper>
	);
};
const DetailWrapper = styled.div`
	width: 100%;
	height: 40%;
	border: 3px solid ${theme.colors.white}
	padding: 20px;
	background-color: ${theme.colors.black};
	position: absolute;
	box-sizing: border-box;
	z-index: 9999;
`;
const Text = styled(Span)`
	color: ${theme.colors.white};
`;
export default GameDetailScore;
