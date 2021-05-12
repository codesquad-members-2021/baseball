import { useEffect, useState } from "react";
import styled from 'styled-components';
import { divideArray } from "../../../common/util";
import Desc from './partial/Desc';
import SelectGame from './partial/selectGame/SelectGame';
import useFetch from '../../../hooks/useFetch';

const SelectTemplate = () => {
    const [teamName, setTeamName] = useState([]);
    const [test,setTest] = useState([]);
    const [desc, setDesc] = useState("참가할 게임을 선택하세요.");
    const { response, loading, error } = useFetch('/api/intro');

    useEffect(() => {
        if (loading) return;
        console.log(error, response);
        setTeamName(response.teams.map(v => v.name));
        let boolean = ["true","true","true","true","true","false"].sort(() => {
            return Math.random() - Math.random();
        });
        setTest(boolean);
    // eslint-disable-next-line react-hooks/exhaustive-deps
    }, [loading]);

    return (
        <StyledSelectTemplate>
            <Desc>{desc}</Desc>
            {teamName && teamName.length && <SelectGame refinedTeamData={divideArray(teamName, 2)} TeamDataBoolean={divideArray(test, 2)} setDesc={setDesc} />}
        </StyledSelectTemplate>
    );
};

export default SelectTemplate;

// --- Styled Components ---
const StyledSelectTemplate = styled.div`
    text-align: center;
    margin: 0 5%;
`;