import styled from "styled-components";

const BallCount = ({ count }) => (
	<StyledBallCount>
		<Count type="B" count={count.ball} />
		<Count type="S" count={count.strike} />
		<Count type="O" count={count.out} />
	</StyledBallCount>
);

const StyledBallCount = styled.div`
	position: absolute;
	top: 185px;
	left: 10px;
`;

const Count = ({ type, count }) => (
	<StyledCount type={type}>
		<CountTitle>{type}</CountTitle>
		<CountOn>{"●".repeat(count)}</CountOn>
		<CountOff>{"●".repeat((type === "B" ? 3 : 2) - count)}</CountOff>
	</StyledCount>
);

const StyledCount = styled.div`
	color: ${({ type }) => {
		if (type === "B") return "green";
		if (type === "S") return "yellow";
		if (type === "O") return "red";
	}};
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
