import GlobalStyle from './components/Style/GlobalStyle';
import { theme } from './components/Style/Theme';
import styled from 'styled-components';
import StartPage from './components/StartPage';

const SpanTag5 = styled.div`
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.bold};
`;

function App() {
	return (
		<>
			<GlobalStyle />
			<StartPage></StartPage>
			<SpanTag5>하이</SpanTag5>
		</>
	);
}

export default App;
