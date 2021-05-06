import styled from "styled-components";
import BallCount from "./BallCount";

const Main = () => {
	const gongSoo = "ATTACK";
	const count = { ball: 2, strike: 1, out: 2 };
	return (
		<StyledMain>
			<BallCount count={count} />
			<CurrentInning>8회초 수비</CurrentInning>
			{gongSoo === "DEFENSE" && <PitchButton>Pitch</PitchButton>}
			<Pitcher src="image/pitcher_eagles_heart.png" />
			<Runner src="image/runner_running.png" />
			<RunnerWaiting src="image/runner_waiting.png" />
			<Batter src="image/batter.png" />
			<PitchButton>PITCH</PitchButton>
		</StyledMain>
	);
};

const StyledMain = styled.div`
	width: 960px;
	height: 540px;
	background-image: url("image/base2.png");
`;
const CurrentInning = styled.div`
	position: absolute;
	top: 200px;
	left: 780px;
	font-size: 30px;
`;
const PitchButton = styled.button`
	position: absolute;
	top: 507px;
	left: 431px;
	width: 100px;
	height: 35px;

	display: flex;
	align-items: center;
	justify-content: center;

	background-color: rgba(0, 0, 0, 0.65);
	color: #fff;
`;
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
