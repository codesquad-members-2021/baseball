import styled from 'styled-components/';

export const theme = {
	colors: {
		white: '#FFFFFF',
		black: '#3333333',
		red: '#e05858',
		red_log: '#db5f28',
		skyblue_log: '#9bc6c9',
		blue_log: '#6ab0b5',
		yellow: '#e8f732',
		green: '#3bcf4c',
		grey: '#bdbdbd',
		grey_list: '#c4c4c4',
		grey_deep: '#9e9e9e',
		grey_transparent: 'rgb(233,236,239,0.5)',
		transparent: 'rgb(0,0,0,0)',
	},
	fontSize: {
		small: '14px',
		medium: '18px',
		large: '26px',
		X_large: '30px',
		XX_large: '40px',
		TITLE: '60px',
	},
	fontWeight: {
		bold: 800,
		normal: 400,
	},
	padding: {
		globalPadding: '0 40px',
	},
};

export const AlignTextCenter = styled.div`
	display: flex;
	align-items: center;
	justify-content: center;
`;

export const Span = styled.span`
	display: inline-block;
	text-align: center;
	font-size: ${theme.fontSize.medium};
	font-weight: ${theme.fontWeight.light};
`;
