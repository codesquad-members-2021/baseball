import GlobalStyle from './components/Style/GlobalStyle';
import StartPage from './components/StartPage';
import AttackMode from './components/AttackMode';
import DefenseMode from './components/DefenseMode';
import { Route } from 'react-router-dom';

function App() {
	return (
		<>
			<GlobalStyle />
			<StartPage />
			<Route exact path="/attack/:id/:away/:home" component={AttackMode} />
			<Route path="/defense" component={DefenseMode} />
		</>
	);
}

export default App;
