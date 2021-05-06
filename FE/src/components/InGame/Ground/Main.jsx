import styled from "styled-components";

const Main = () => {
	const gongSoo = "ATTACK";
	return (
		<StyledMain>
			<BallCount></BallCount>
			<CurrentInning>9회초 수비</CurrentInning>
			{gongSoo === "DEFENSE" && <PitchButton>Pitch</PitchButton>}
			<Pitcher src="image/pitcher_eagles_heart.png" />
			<Runner src="image/runner.png" />
			<RunnerWaiting src="image/runner_waiting.png" />
			<Batter src="image/batter.png" />
		</StyledMain>
	);
};

const StyledMain = styled.div`
	width: 960px;
	height: 540px;
	background-image: url("image/base2.png");
`;
const BallCount = styled.div``;
const CurrentInning = styled.div`
	position: absolute;
	top: 200px;
	left: 780px;
	font-size: 30px;
`;
const PitchButton = styled.button``;
const Pitcher = styled.img`
	position: absolute;
	top: 380px;
	left: 450px;
	width: 60px;
`;
const Runner = styled.img`
	position: absolute;
	top: 270px;
	left: 563px;
	width: 80px;
`;
const RunnerWaiting = styled.img`
	position: absolute;
	top: 148px;
	left: 443px;
	width: 80px;
`;
const Batter = styled.img`
	position: absolute;
	top: 575px;
	left: 375px;
	width: 70px;
`;

export default Main;
