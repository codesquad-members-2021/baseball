import { useState } from "react";
import styled from 'styled-components';
import { divideArray } from "../../../common/util";
import Desc from './partial/Desc';
import SelectGame from './partial/selectGame/SelectGame';

const SelectTemplate = () => {
    const [teamData] = useState(['Captin', 'Marvel', 'Twins', 'Tigers', 'Rockets', 'Dodgers']);

    return (
        <StyledSelectTemplate>
            <Desc>참가할 게임을 선택하세요.</Desc>
            <SelectGame refinedTeamData={divideArray(teamData, 2)} />
        </StyledSelectTemplate>
    );
};

export default SelectTemplate;

// --- Styled Components ---
const StyledSelectTemplate = styled.div`
    text-align: center;
`;