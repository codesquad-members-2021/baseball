import { useState } from "react";
import styled from "styled-components";
import BallCount from "./BallCount";

const Field = () => {
	const gongSoo = "DEFENSE";
	const count = { ball: 2, strike: 1, out: 2 };

	const [runnerList, setRunnerList] = useState([
		{
			base: 0,
		},
	]);

	const [isInPlay, setInPlay] = useState(false);

	const [pitchingStep, setpitchingStep] = useState("windup");

	const pitch = async () => {
		await windup();
		await throwing();
		await release();
	};

	const windup = () =>
		new Promise((res, rej) => {
			setpitchingStep("windup");
			setTimeout(() => res(), 200);
		});
	const throwing = () =>
		new Promise((res, rej) => {
			setpitchingStep("throwing");
			setTimeout(() => res(), 250);
		});
	const release = () =>
		new Promise((res, rej) => {
			setpitchingStep("release");
			setTimeout(() => res(), 150);
		});

	const hit = async () => {
		if (isInPlay) return;
		setInPlay(() => true);
		await pitch();
		await run();
		arrive();
		setInPlay(() => false);
	};

	const run = () =>
		new Promise((res, rej) => {
			setRunnerList((list) => [
				...list.map((el) => {
					return { base: el.base++, isRunning: true };
				}),
				{
					base: 0,
				},
			]);
			setTimeout(() => res(), 400);
		});

	const arrive = () => {
		setRunnerList((list) => [
			...list.map((el) => {
				el.isRunning = false;
				if (el.base % 4 === 0 && el.base !== 0) el.isScoring = true;
				return el;
			}),
		]);
	};

	return (
		<StyledField>
			<BallCount count={count} />

			<CurrentInning>8회초 수비</CurrentInning>

			<Pitcher step={pitchingStep} />

			{runnerList.map((el, i) => (
				<Runner key={i} {...el} />
			))}

			{isInPlay || <Batter src="image/batter.png" />}

			{gongSoo === "DEFENSE" && <PitchButton onClick={hit}>PITCH</PitchButton>}
		</StyledField>
	);
};

const StyledField = styled.div`
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
	visibility: ${({ base, isScoring }) => (base === 0 || isScoring ? "hidden" : "visible")};
	transform: ${({ base, isRunning }) => ((base % 4 === 0 || base % 4 === 1) && isRunning ? "scaleX(-1);" : "")};

	position: absolute;
	width: 80px;

	transition: top 400ms, left 400ms;
`;
const Batter = styled.img`
	position: absolute;
	top: 575px;
	left: 375px;
	width: 70px;
`;

export default Field;
