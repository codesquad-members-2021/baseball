import React from 'react';
import GamePage from '../GamePage';
const AttackMode = ({ match }) => {
	console.log(match.params);
	return (
		<>
			<div>어택모드</div>
			<GamePage data={match.params} />
		</>
	);
};

export default AttackMode;
