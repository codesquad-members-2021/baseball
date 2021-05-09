import styled from 'styled-components';
import SelectGameItem from './SelectGameItem';

const SelectGame = ({ refinedTeamData }) => {
    const gameItems =
        refinedTeamData &&
        refinedTeamData.length > 0 &&
        refinedTeamData.map((arr, i) => (
            // 원정팀이 왼쪽
            <SelectGameItem
                key={i}
                idx={i + 1}
                away={arr[0]}
                home={arr[1]}
                to={'/game'}
            />
        ));

    return (
        <StyledSelectGame>
            {gameItems}
            <SelectGameItem
                idx={refinedTeamData.length+1}
                away={'여기는'}
                home={'없는페이지'}
                to={'/404'}
            />
        </StyledSelectGame>
    );
};

export default SelectGame;

// --- Styled Components ---
const StyledSelectGame = styled.ul`
    margin-top: 24px;
`;
