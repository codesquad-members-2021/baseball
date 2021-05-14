import React from 'react';
import styled from 'styled-components';
import { theme } from '../../Style/Theme';
import GpaField from './GPA_Field';
import GpaBallCount from './GPA_BallCount';
const GamePlayArea = ({ type, id }) => {
	return (
		<GamePlayAreaWrapper>
			<GpaBallCount />
			<AlignCenterWrapper>
				<GpaField type={type} gameId={id} />
			</AlignCenterWrapper>
		</GamePlayAreaWrapper>
	);
};
const GamePlayAreaWrapper = styled.div`
	border-right: 5px solid ${theme.colors.white};
`;
const AlignCenterWrapper = styled.div`
	top: -50%;
	left: 23%;
`;
export default GamePlayArea;
