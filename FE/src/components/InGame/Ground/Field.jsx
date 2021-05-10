import { useState } from "react";
import styled from "styled-components";
import delay from "../../../utils/delay/delay";
import BallCount from "./BallCount";

const Field = () => {
	const gongSoo = "DEFENSE";
	const count = { ball: 2, strike: 1, out: 1 };

	const [runnerList, setRunnerList] = useState([{ base: 0 }]);
	const [isPlaying, setPlaying] = useState(false);

	const [pitchingStep, setpitchingStep] = useState("release");

	const pitch = async () => {
		await delay(() => setpitchingStep("windup"), 200);
		await delay(() => setpitchingStep("throwing"), 250);
		await delay(() => setpitchingStep("release"), 150);
	};

	const hit = async () => {
		setPlaying(() => true);
		await delay(run, 400);
		arrive();
		setPlaying(() => false);
	};

	const run = () => setRunnerList((list) => [...list.map((el) => ({ base: el.base++, isRunning: true })), { base: 0 }]);

	const arrive = () => setRunnerList((list) => [...list.map((el) => ({ ...el, isRunning: false }))]);

	const play = async () => {
		await pitch();
		await hit();
	};
	//prettier-ignore
	return (
		<StyledField>
			<BallCount count={count} />
			<CurrentInning>8회초 수비</CurrentInning>
			<Pitcher step={pitchingStep} />
			{runnerList.map((el, i) => <Runner key={i} {...el} />)}
			{isPlaying || <Batter src="image/batter.png" />}
			{gongSoo === "DEFENSE" && <PitchButton onClick={play}>PITCH</PitchButton>}
		</StyledField>
	);
};

const StyledField = styled.div`
	width: 960px;
	height: 540px;
	background-image: url("image/base.png");
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
const Pitcher = styled.img.attrs(({ step }) => ({
	src: `image/pitcher_${step}.png`,
}))`
	position: absolute;
	top: 380px;
	left: 450px;
	width: ${({ step }) => (step === "windup" ? "50px" : "60px")};
`;

const baseLocation = [
	{ base: 0, top: "560px", left: "492px" },
	{ base: 1, top: "318px", left: "631px" },
	{ base: 2, top: "144px", left: "407px" },
	{ base: 3, top: "357px", left: "253px" },
];

const Runner = styled.img.attrs(({ base, isRunning }) => ({
	src: isRunning ? "image/runner_running.png" : "image/runner_waiting.png",
	style: baseLocation[base % 4],
}))`
	visibility: ${({ base, isRunning }) => (base % 4 === 0 && !isRunning ? "hidden" : "visible")};
	transform: ${({ base, isRunning }) => ((base % 4 === 0 || base % 4 === 1) && isRunning ? "scaleX(-1);" : "")};

	position: absolute;
	width: 80px;

	transition: top 590ms, left 590ms;
`;
const Batter = styled.img`
	position: absolute;
	top: 575px;
	left: 375px;
	width: 70px;
`;

export default Field;
