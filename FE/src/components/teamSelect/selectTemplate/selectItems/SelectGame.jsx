import styled from 'styled-components';
import SelectGameItem from './SelectGameItem';

const SelectGame = ({ refinedTeamData }) => {
    const gameItems =
        refinedTeamData &&
        refinedTeamData.length > 0 &&
        refinedTeamData.map((arr, i) => (
            // 원정팀이 왼쪽
            <SelectGameItem key={i} idx={i + 1} away={arr[0]} home={arr[1]} />
        ));

    return <StyledSelectGame>{gameItems}</StyledSelectGame>;
};

export default SelectGame;

// --- Styled Components ---
const StyledSelectGame = styled.ul`
    margin-top: 24px;
`;
