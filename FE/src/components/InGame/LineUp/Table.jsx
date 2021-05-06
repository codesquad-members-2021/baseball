import styled from "styled-components";

const Table = ({ slide }) => {
	return (
		<StyledTable slide={slide}>
			<TableContent />
			<TableContent />
		</StyledTable>
	);
};

const TableContent = () => {
	return (
		<StyledTableContent>
			<caption>Team name</caption>
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
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<tr>
					<td>김광현</td>
					<td>2</td>
					<td>1</td>
					<td>1</td>
					<td>0.500</td>
				</tr>
				<Total>
					<td>Totals</td>
					<td>18</td>
					<td>9</td>
					<td>9</td>
					<td>0.500</td>
				</Total>
			</tbody>
		</StyledTableContent>
	);
};

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
	transition: 400ms;

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
