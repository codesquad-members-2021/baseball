import React from 'react';
import styled from 'styled-components';
import { theme, Span } from '../../Style/Theme';
const GPA_BallCount = () => {
	return (
		<GPA_BallCount_Wrapper>
			<FlexWrapper>
				<BallType>S</BallType> <Circle type="S" />
			</FlexWrapper>

			<FlexWrapper>
				<BallType>B</BallType> <Circle type="B" />
			</FlexWrapper>
			<FlexWrapper>
				<BallType>O</BallType> <Circle type="O" />
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
