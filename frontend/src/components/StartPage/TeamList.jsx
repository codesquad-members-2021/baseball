import React from 'react';
import API from '../Hook/API';
const TeamList = () => {
	const foo = async () => {
		try {
			const { games } = await API.get.teamList();
		} catch (err) {
			console.error(err); //error처리
		}
	};

	foo();
	return <div>팀목록</div>;
};

export default TeamList;
