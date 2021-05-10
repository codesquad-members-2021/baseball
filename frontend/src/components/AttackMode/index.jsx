import React from 'react';
import GamePage from '../GamePage';
const AttackMode = ({ match }) => {
	const id = match.params;
	return (
		<>
			<div>어택모드</div>
			<GamePage data={match.params} type="Attack" />
		</>
	);
};

export default AttackMode;
