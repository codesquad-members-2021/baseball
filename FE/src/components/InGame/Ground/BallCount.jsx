import styled from "styled-components";

const BallCount = ({ hitterRecords }) => {
	const count = hitterRecords[0].results.reduce((acc, cur) => ({ ...acc, ball: cur === "B" ? ++acc.ball : acc.ball, strike: cur === "S" ? ++acc.strike : acc.strike }), { ball: 0, strike: 0, out: hitterRecords.reduce((acc, cur) => (cur.out ? acc + 1 : acc), 0) });
	return (
		<StyledBallCount>
			<Count type="BALL" count={count.ball} />
			<Count type="STRIKE" count={count.strike} />
			<Count type="OUT" count={count.out} />
		</StyledBallCount>
	);
};

const Count = ({ type, count }) => (
	<StyledCount type={type}>
		<CountTitle>{type[0]}</CountTitle>
		<CountOn>{"●".repeat(count)}</CountOn>
		<CountOff>{"●".repeat((type === "BALL" ? 3 : 2) - count)}</CountOff>
	</StyledCount>
);

const StyledBallCount = styled.div`
	position: absolute;
	top: 185px;
	left: 10px;
`;
const colorMap = {
	BALL: "#080",
	STRIKE: "#ff0",
	OUT: "#f00",
};
const StyledCount = styled.div`
	color: ${({ type }) => colorMap[type]};
	font-size: 40px;
	height: 45px;
	display: flex;
	letter-spacing: 15px;
`;
const CountTitle = styled.div`
	width: 50px;
	text-align: center;
	color: #fff;
`;
const CountOn = styled.div``;
const CountOff = styled.div`
	filter: brightness(18%);
`;

export default BallCount;
