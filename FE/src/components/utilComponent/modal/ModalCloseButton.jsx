import styled, { css } from 'styled-components';
import { IoClose } from 'react-icons/io5';

const ModalCloseButton = ({ children, ...props }) => (
    <StyledModalCloseButton {...props}>
        {children || <IoClose />}
    </StyledModalCloseButton>
);

export default ModalCloseButton;

// --- Styled Components ---
const StyledModalCloseButton = styled.button`
    background-color: transparent;
    background-repeat: no-repeat;
    overflow: hidden;
    outline: none;
    border: none;

    ${({ cssCloseButtonStyle }) =>
        cssCloseButtonStyle
            ? cssCloseButtonStyle
            : css`
                  position: absolute;
                  top: 0;
                  right: -30px;
              `};

    cursor: pointer;
    color: ${({ theme }) => theme.colors.white || '#FFF'};
    font-size: ${({ theme }) => theme.fontSize.XL || '24px'};
`;
