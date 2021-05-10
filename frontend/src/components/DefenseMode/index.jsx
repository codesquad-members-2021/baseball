import React from 'react';
import GamePage from '../GamePage';
const DefenseMode = ({ match }) => {
	const id = match.params;
	return (
		<>
			<GamePage data={id} type="Defense" />
		</>
	);
};

export default DefenseMode;
