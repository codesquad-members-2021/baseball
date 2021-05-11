import styled from "styled-components";
import makeDecimalPoint from "../../../utils/makeDecimalPoint/makeDecimalPoint";

const Table = ({ data, slide }) => (
	<StyledTable slide={slide}>
		{data && <TableContent name={data.awayTeam.name} data={data.awayTeam.playerStatuses} />}
		{data && <TableContent name={data.homeTeam.name} data={data.homeTeam.playerStatuses} />}
	</StyledTable>
);
//prettier-ignore
const TableContent = ({ name, data }) => (
	<StyledTableContent>
		<caption>{name}</caption>
		<thead>
			<tr>
				<th>타자</th>
				<th>타석</th>
				<th>안타</th>
				<th>아웃</th>
				<th>평균</th>
			</tr>
		</thead>
		<tbody>
			{data.map((el) => <Player key={el.id} {...el} />)}
			<Total>
				<td>Totals</td>
				<td>{data.reduce((acc, cur) => acc + cur.plateAppearanceCount, 0)}</td>
				<td>{data.reduce((acc, cur) => acc + cur.hitCount, 0)}</td>
				<td>{data.reduce((acc, cur) => acc + cur.plateAppearanceCount - cur.hitCount, 0)}</td>
				<td>{makeDecimalPoint(data.reduce((acc, cur) => acc + cur.hitCount, 0) / data.reduce((acc, cur) => acc + cur.plateAppearanceCount, 0), 3)}</td>
			</Total>
		</tbody>
	</StyledTableContent>
);

const Player = ({ name, plateAppearanceCount, hitCount }) => (
	<tr>
		<td>{name}</td>
		<td>{plateAppearanceCount}</td>
		<td>{hitCount}</td>
		<td>{plateAppearanceCount - hitCount}</td>
		<td>{makeDecimalPoint(hitCount / plateAppearanceCount, 3)}</td>
	</tr>
);

const StyledTable = styled.div`
	position: absolute;
	border: 3px solid #fff;
	display: flex;
	justify-content: center;
	align-items: center;
	width: 960px;
	height: 610px;
	top: ${(props) => (props.slide ? "55px" : "720px")};
	left: 160px;
	transition: top 400ms;

	z-index: 2;

	background-color: rgba(0, 0, 0, 0.8);
`;

const StyledTableContent = styled.table`
	color: white;

	text-align: center;
	font-size: 24px;
	caption {
		font-size: 32px;
		font-weight: bold;
		padding: 10px;
		border-bottom: 3px solid #fff;
	}
	th,
	td {
		padding: 12px 18px;
	}
	th {
		color: gray;
		border-bottom: 2px solid #494949;
	}
	tr + tr {
		border-top: 1px solid #b6b6b6;
	}
	& + & {
		border-left: 3px solid #fff;
	}
`;

const Total = styled.tr`
	font-weight: bold;
	padding: 12px 20px;
`;

export default Table;
