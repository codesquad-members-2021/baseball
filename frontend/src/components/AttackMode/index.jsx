import React from 'react';
import GamePage from '../GamePage';
const AttackMode = ({ match }) => {
	const id = match.params;
	return (
		<>
			<GamePage data={match.params} type="Attack" />
		</>
	);
};

export default AttackMode;
