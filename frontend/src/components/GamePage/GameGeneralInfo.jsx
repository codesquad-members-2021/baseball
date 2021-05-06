import React from 'react';
import { theme } from '../Style/Theme';
import styled from 'styled-components';
const GameGeneralInfo = ({ data }) => {
	console.log(data);
	return <Title>BASEBALL GAME ONLINE</Title>;
};

const Title = styled.div`
	font-size: ${theme.fontSize.XX_large};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
`;

export default GameGeneralInfo;
