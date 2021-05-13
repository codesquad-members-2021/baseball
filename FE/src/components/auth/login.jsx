import { useContext } from 'react';
import styled from 'styled-components';
import LoginModal from "../utilComponent/modal/Modal";
import { GlobalContext } from "../utilComponent/context/GlobalProvider";

const Login = () => {
    const { globalState, globalDispatch } = useContext(GlobalContext);
    const visibleOptions = {
        isModalVisible: globalState.loginModalVisible,
        setIsModalVisible: () => globalDispatch({ type: "loginModalVisibleControl" }),
    };

    return (
        <LoginModal visibleOptions={visibleOptions}>
            <div></div>
        </LoginModal>
    );
};

export default Login;

// --- Styled Components ---

const LoginButton = styled.div`
    /* cursor: pointer;
    position: absolute; */
`;
