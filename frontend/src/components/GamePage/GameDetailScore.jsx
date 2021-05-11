import styled from 'styled-components';
import { Span, theme } from '../Style/Theme';
const GameDetailScore = () => {
	return <DetailWrapper>상세점수현황</DetailWrapper>;
};
const DetailWrapper = styled(Span)`
	color: ${theme.colors.white};
`;
export default GameDetailScore;
