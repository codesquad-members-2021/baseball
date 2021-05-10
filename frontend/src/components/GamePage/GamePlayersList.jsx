import styled from 'styled-components';
import { Span, theme } from '../Style/Theme';

const GamePlayersList = () => {
	return <PlayerWrapper>게임선수명단</PlayerWrapper>;
};

const PlayerWrapper = styled(Span)`
	color: ${theme.colors.white};
`;
export default GamePlayersList;
