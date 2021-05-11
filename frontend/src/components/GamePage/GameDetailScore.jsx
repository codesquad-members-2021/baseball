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
	background-color: green;
	position: absolute;
	box-sizing: border-box;
`;
const Text = styled(Span)`
	color: ${theme.colors.white};
`;
export default GameDetailScore;
