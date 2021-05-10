import styled from "styled-components";

const Score = ({homeTeam, awayTeam}) => {
	return (
		<StyledScore>
			<Title>BASEBALL GAME ONLINE</Title>
			<Team>
				<TeamName>{awayTeam.name}</TeamName>
				<TeamScore>{awayTeam.score}</TeamScore>
				vs
				<TeamScore>{homeTeam.score}</TeamScore>
				<TeamName>{homeTeam.name}</TeamName>
			</Team>
		</StyledScore>
	);
};

const StyledScore = styled.div`
	height: 180px;
	border-bottom: 3px solid gray;
	background-color: #000;
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: space-evenly;
	font-weight: bold;
`;
const Title = styled.div`
	font-size: 30px;
`;
const Team = styled.div`
	width: 90%;
	display: flex;
	justify-content: space-evenly;
	align-items: center;
	color: gray;
	font-size: 40px;
`;
const TeamName = styled.div`
	color: #fff;
	font-size: 60px;
`;
const TeamScore = styled.div`
	color: #fff;
	font-size: 60px;
`;
export default Score;
