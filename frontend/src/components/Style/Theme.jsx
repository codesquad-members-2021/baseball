import styled from 'styled-components/';

export const theme = {
	colors: {
		white: '#FFFFFF',
		black: '#3333333',
		red: '#e05858',
		red_log: '#db5f28',
		skyblue_log: '#9bc6c9',
		blue_log: '#6ab0b5',
		grey: '#bdbdbd',
		yello: '#e8f732',
		green: '#3bcf4c',
	},
	fontSize: {
		small: '14px',
		medium: '18px',
		large: '26px',
		larger: '30px',
		X_large: '40px',
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
