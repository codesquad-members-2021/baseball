import React from 'react';
import styled from 'styled-components';
import { theme, Span } from '../../Style/Theme';
import { useDispatch, useGameState } from '../../GameContext';

const GPA_BallCount = () => {
	const { state } = useGameState();
	console.log(state);
	// console.log(state.gameStatusDTO.ballCount);
	// console.log(state.gameStatusDTO.strikeCount);
	// console.log(state.gameStatusDTO.outCount);

	const BallCount = (type, count) => {
		return Array.from({ length: count }).map((v) => <Circle type={type} />);
	};
	const Ball = state.gameStatusDTO
		? BallCount('B', state.gameStatusDTO.ballCount)
		: null;
	const Strike = state.gameStatusDTO
		? BallCount('S', state.gameStatusDTO.strikeCount)
		: null;
	const Out = state.gameStatusDTO
		? BallCount('O', state.gameStatusDTO.outCount)
		: null;

	return (
		<GPA_BallCount_Wrapper>
			<FlexWrapper>
				<BallType>S</BallType>
				{Strike}
			</FlexWrapper>

			<FlexWrapper>
				<BallType>B</BallType>
				{Ball}
			</FlexWrapper>

			<FlexWrapper>
				<BallType>O</BallType>
				{Out}
			</FlexWrapper>
		</GPA_BallCount_Wrapper>
	);
};
const GPA_BallCount_Wrapper = styled.div`
	position: inherit;
	margin: 30px;
`;
const switchColor = (type) => {
	if (type === 'S') return theme.colors.red;
	else if (type === 'B') return theme.colors.yellow;
	else return theme.colors.green;
};
const Circle = styled.div`
	width: 20px;
	height: 20px;
	border-radius: 50%;
	background-color: ${(props) => switchColor(props.type)};
	margin-left: 15px;
`;
const FlexWrapper = styled.div`
	display: flex;
	align-items: center;
`;
const BallType = styled(Span)`
	font-size: ${theme.fontSize.large};
	font-weight: ${theme.fontWeight.light};
	color: ${theme.colors.white};
`;
export default GPA_BallCount;

// gameStatus:
// ballCount: 0
// currentHitter: 0
// currentPitcher: 0
// inning: 1
// nextHitter: 1
// outCount: 0
// strikeCount: 0
// top: true

// gameStatusDTO:
// ballCount: 0
// currentHitter: 0
// currentPitcher: 0
// inning: 1
// nextHitter: 1
// outCount: 0
// strikeCount: 1
// top: true
