import { useContext, useEffect, useState } from 'react';
import styled from 'styled-components';
import LoginModal from "../utilComponent/modal/Modal";
import { GlobalContext } from "../utilComponent/context/GlobalProvider";
import useFetch from '../../hooks/useFetch';
import { githubProvider } from "../../config/authMethods";
import socialMediaAuth from "./auth";

const Login = () => {
    const { globalState, globalDispatch } = useContext(GlobalContext);
    const visibleOptions = {
        isModalVisible: globalState.loginModalVisible,
        setIsModalVisible: () => globalDispatch({ type: "loginModalVisibleControl" }),
    };

    // const { response, loading, error } = useFetch('api/login');
    // useEffect(() => {
    //     if(loading) return;
    //     console.log("너냐? : ",response)
    // },[loading]);

    // useEffect(async () => {
    //     const data = await fetch('http://52.78.180.217/api/login').then(res => res.json());
    //     console.log(data);
    // },[])

    const handleOnClick = async (provider) => {
        const res = await socialMediaAuth(provider);
        globalDispatch({ type: "userLogin", payload: res.displayName })
        globalDispatch({ type: "loginModalVisibleControl" });
    };

    return (
        <LoginModal visibleOptions={visibleOptions}>
            <GitButton onClick={() => handleOnClick(githubProvider)}/>
        </LoginModal>
    );
};

export default Login;

// --- Styled Components ---

const GitButton = styled.div`
    cursor: pointer;
    width:120px;
    height:50px;
    border-radius:10px;
    background-image:url("/images/github.jpeg");
    background-size:cover;
    background-repeat:no-repeat;
    background-position:center;
    margin:5px 10px 0 0;
`;
