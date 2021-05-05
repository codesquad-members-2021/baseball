import styled from "styled-components";

const Table = ({ slide }) => {
	const inning = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, "R"];

	return (
		<StyledTable slide={slide}>
			<thead>
				<tr>
					<th>&nbsp;</th>
				</tr>
				<tr>
					<th>awayTeam</th>
				</tr>
				<tr>
					<th>homeTeam</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					{inning.map((e) => (
						<Inning key={e}>{e}</Inning>
					))}
				</tr>
				<tr>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>1</td>
					<td>0</td>
					<td>0</td>
					<td></td>
					<td></td>
					<td></td>
					<Sum>1</Sum>
				</tr>
				<tr>
					<td>3</td>
					<td>3</td>
					<td>5</td>
					<td>0</td>
					<td>1</td>
					<td>2</td>
					<td>0</td>
					<td>0</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<Sum>14</Sum>
				</tr>
			</tbody>
		</StyledTable>
	);
};

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
	transition: 400ms;

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
