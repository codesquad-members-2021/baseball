import styled from 'styled-components';
import ModalCloseButton from './ModalCloseButton';

const Modal = ({
    visibleOptions: {
        isModalVisible = null,
        setIsModalVisible = () => {},
        addCbFunc = null,
    } = {
        isModalVisible: null,
        setIsModalVisible: () => {},
        addCbFunc: null,
    },
    cssCloseButtonStyle = null,
    ...props
}) => {
    const handleCloseBtnClick = () => {
        addCbFunc && addCbFunc();
        setIsModalVisible(!isModalVisible);
    };

    return (
        <StyledModal isModalVisible={isModalVisible}>
            <ModalWrapper>
                {props.children || (
                    <SampleContent>
                        <p className="large">Modal</p>
                        <p>Please write the content!</p>
                        <p className="close">Close plz..</p>
                    </SampleContent>
                )}
                <ModalCloseButton
                    onClick={isModalVisible !== null && handleCloseBtnClick}
                    cssCloseButtonStyle={cssCloseButtonStyle}
                />
            </ModalWrapper>
        </StyledModal>
    );
};

export default Modal;

// --- Styled Components ---
const StyledModal = styled.div`
    visibility: ${({ isModalVisible }) =>
        isModalVisible ? 'visible' : 'hidden'};

    position: fixed;
    top: 0;
    right: 0;
    bottom: 0;
    left: 0;
    z-index: 9999;

    display: flex;
    justify-content: center;
    align-items: center;

    background-color: rgba(0, 0, 0, 0.4);
`;

const ModalWrapper = styled.div`
    position: relative;
`;

// children 없을 경우 ----
const SampleContent = styled.div`
    padding: 48px;
    background-color: #fff;
    border-radius: 5px;
    font-size: 18px;

    p.large {
        font-size: 2rem;
    }

    p.close {
        color: #5c5b5b;
        font-size: 14px;
    }

    p + p {
        margin-top: 8px;
    }
`;
