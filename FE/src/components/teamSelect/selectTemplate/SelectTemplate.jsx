import { useEffect, useState } from "react";
import styled from 'styled-components';
import { divideArray } from "../../../common/util";
import Desc from './partial/Desc';
import SelectGame from './partial/selectGame/SelectGame';
import useFetch from '../../../hooks/useFetch';

const SelectTemplate = () => {
    const [teamData, setTeamData] = useState([]);

    const { response, loading, error } = useFetch('/api/intro');

    useEffect(() => {
        if (loading) return;
        console.log(error, response);
        setTeamData(response.teams.map(v => v.name));
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [loading]);

    return (
        <StyledSelectTemplate>
            <Desc>참가할 게임을 선택하세요.</Desc>
            {teamData && teamData.length && <SelectGame refinedTeamData={divideArray(teamData, 2)} />}
        </StyledSelectTemplate>
    );
};

export default SelectTemplate;

// --- Styled Components ---
const StyledSelectTemplate = styled.div`
    text-align: center;
    margin: 0 5%;
`;