import React from 'react';
import styled from 'styled-components';
import { theme } from '../../Style/Theme';
import GPA_Field from './GPA_Field';
import GPA_BallCount from './GPA_BallCount';
const GamePlayArea = ({ type, id }) => {
	return (
		<GamePlayAreaWrapper>
			<GPA_BallCount />
			<AlignCenterWrapper>
				<GPA_Field type={type} gameId={id} />
			</AlignCenterWrapper>
		</GamePlayAreaWrapper>
	);
};
const GamePlayAreaWrapper = styled.div`
	border-right: 5px solid ${theme.colors.white};
`;
const AlignCenterWrapper = styled.div`
	position: relative;
	top: -50%;
	left: 23%;
`;
export default GamePlayArea;
