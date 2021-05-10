import React from 'react';
import styled from 'styled-components';
import { theme, Span } from '../../Style/Theme';
const GPA_Field = ({ type }) => {
	console.log(type);
	const handleClick = () => {
		console.log('hi');
	};
	return (
		<>
			{type === 'Attack' && <PITCH onClick={handleClick}>PITCH</PITCH>}
			<Field_Area>
				<svg
					width="381"
					height="363"
					viewBox="0 0 381 363"
					fill="none"
					xmlns="http://www.w3.org/2000/svg"
				>
					<rect
						x="1.50072"
						y="1.5"
						width="317.288"
						height="305.589"
						transform="matrix(1 0 0.000482605 1 27.1845 27.9561)"
						stroke="white"
						stroke-width="3"
					/>
					<rect
						width="59.2157"
						height="57.0527"
						rx="5"
						transform="matrix(1 0 0.000482605 1 321.553 305.784)"
						fill="white"
					/>
					<rect
						width="59.2157"
						height="57.0527"
						rx="5"
						transform="matrix(1 0 0.000483909 1 0.286499 0)"
						fill="white"
					/>
					<rect
						width="59.2157"
						height="57.0527"
						rx="5"
						transform="matrix(1 0 0.000483909 1 317.898 0)"
						fill="white"
					/>
					<path
						d="M70.444 292.97L62.0914 329.939L31.8289 299.85L70.444 292.97Z"
						fill="white"
					/>
					<rect
						width="41.4964"
						height="44.9802"
						transform="matrix(0.709138 0.705069 -0.730955 0.682425 33.0296 299.535)"
						fill="white"
					/>
				</svg>
			</Field_Area>
			<GameState>2회초 공격</GameState>
		</>
	);
};
const PITCH = styled.button`
	position: relative;
	top: 516px;
	left: 243px;
	cursor: pointer;
	z-index: 9999;
	background-color: ${theme.colors.transparent};
	font-size: ${theme.fontSize.XX_large};
	font-weight: ${theme.fontWeight.Bold};
	color: ${theme.colors.white};
	border: 5px solid ${theme.colors.white};
`;
const Field_Area = styled.div`
	transform: rotate(-45deg);
`;
const GameState = styled(Span)`
	position: relative;
	top: -170px;
	right: -750px;
	font-size: ${theme.fontSize.X_large};
	font-weight: ${theme.fontWeight.light};
	color: ${theme.colors.white};
`;
export default GPA_Field;
