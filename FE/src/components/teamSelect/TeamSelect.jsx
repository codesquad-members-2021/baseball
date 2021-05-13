import { useContext } from 'react';
import styled from 'styled-components';
import SelectTemplate from './selectTemplate/SelectTemplate';
import Logo from '../utilComponent/Logo';
import {GlobalContext} from "../utilComponent/context/GlobalProvider";

const TeamSelect = () => {
    const { globalState, globalDispatch } = useContext(GlobalContext);

    console.log(globalState.user)

    const loginModalOn = () => {
        globalDispatch({ type: "loginModalVisibleControl" })
    }
    
    return (
        <StyledTeamSelect>
            <Logo>CPR BASSBALL GAME</Logo>
            <SelectTemplate />
            <GitHubButton onClick={loginModalOn}>{globalState.userLogin}</GitHubButton>
        </StyledTeamSelect>
    );
};

export default TeamSelect;

// --- Styled Components ---
const StyledTeamSelect = styled.div`
    width: 50%;
    margin: 0 auto;
    text-align: -webkit-center;
`;

const GitHubButton = styled.div`
    cursor: pointer;
    width: 10%;
    margin:10px;
    padding:10px;
    border-radius:5px;
    font-weight:bold;
    font-size:14px;
    background-color:rgb(181,227,216);
    &:active {
        transform:translateY(2px);
    }
`;
