import { useState } from 'react';
import styled from 'styled-components';
import TeamList from './TeamList';
import { theme, AlignTextCenter } from '../Style/Theme';
import Scroll from '../Style/Scroll';
const StartPage = () => {
	const [message, setMessage] = useState('참가할 게임을 선택하세요!');

	return (
		<AlignCenterWrapper>
			<div>
				<Title>BASEBALL GAME ONLINE</Title>
				<Message>{message}</Message>

				<ListWrapper>
					<TeamList setMessage={setMessage} />
				</ListWrapper>
			</div>
		</AlignCenterWrapper>
	);
};

export default StartPage;
const AlignCenterWrapper = styled(AlignTextCenter)`
	margin-top: 20vh;
`;
const Title = styled.div`
	font-size: ${theme.fontSize.TITLE};
	font-weight: ${theme.fontWeight.bold};
	color: ${theme.colors.white};
	text-align: center;
	margin-bottom: 70px;
`;

const Message = styled.div`
	font-size: ${theme.fontSize.large};
	font-weight: ${theme.fontWeight.normal};
	color: ${theme.colors.white};
	text-align: center;
`;

const ListWrapper = styled(Scroll)`
	width: 370px;
	margin: 0 auto;
	max-height: 295px;
`;
