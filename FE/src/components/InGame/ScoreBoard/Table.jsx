import styled from "styled-components";
//prettier-ignore
const Table = ({ data, slide }) => (
	<StyledTable slide={slide}>
		<thead>
			<tr>
				<th>&nbsp;</th>
			</tr>
			<tr>
				<th>{data.awayTeam.name}</th>
			</tr>
			<tr>
				<th>{data.homeTeam.name}</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				{[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, "R"].map(e => <Inning key={e}>{e}</Inning>)}
			</tr>
			<Score score={data.awayTeam.scores} />
			<Score score={data.homeTeam.scores} />
		</tbody>
	</StyledTable>
);
//prettier-ignore
const Score = ({ score }) => (
	<tr>
		{[...score, ...Array.from({ length: 12 }).fill("")].slice(0, 12).map((e, i) => <td key={100 * e + i}>{e}</td>)}
		<Sum>{score.length && score.reduce((acc, cur) => acc + cur, 0)}</Sum>
	</tr>
);

const StyledTable = styled.table`
	position: absolute;
	border: 3px solid #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	width: 1100px;
	height: 180px;
	top: ${(props) => (props.slide ? "20px" : "-200px")};
	left: 90px;
	transition: top 400ms;

	z-index: 2;

	background-color: rgba(0, 0, 0, 0.8);

	color: white;
	text-align: center;
	font-size: 26px;
	font-weight: bold;
	th,
	td {
		padding: 10px;
		width: 60px;
	}
`;
const Inning = styled.th`
	border-bottom: 1px solid white;
`;
const Sum = styled.td`
	color: red;
`;

export default Table;
