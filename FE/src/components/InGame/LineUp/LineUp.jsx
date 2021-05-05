import styled from "styled-components";
import Table from "./Table";

const LineUp = ({ slide, toggle, isDark, setDark }) => {
	return (
		<StyledLineUp>
			<NearChecker
				onMouseEnter={() => {
					if (isDark) return;
					toggle(true);
					setDark(true);
				}}
			/>
			<Table slide={slide} />
		</StyledLineUp>
	);
};
const StyledLineUp = styled.div``;
const NearChecker = styled.div`
	position: absolute;
	width: 1280px;
	height: 100px;
	top: 620px;
`;

export default LineUp;
