import styled from 'styled-components';
import PopupFrameBackground from './PopupFrameBackground';
import { cssFullAbsolutePosition } from '../CommonStyledCSS';

const PopupFrame = ({
    children,
    options: {
        zIndex = null,
        isBottom = false,
        visible = false,
        callBackFrameLeave = null
    } = {
        zIndex: null,
        isBottom: false,
        visible: false,
        callBackFrameLeave: null,
    },
}) => {
    const handleMouseLeave = () => callBackFrameLeave && callBackFrameLeave(false);

    return (
        <StyledPopupFrame visible={visible} >
            <PopupFrameBackground zIndex={zIndex} />
            <Frame zIndex={zIndex} isBottom={isBottom} onMouseLeave={handleMouseLeave}>
                {children}
            </Frame>
        </StyledPopupFrame>
    );
};

export default PopupFrame;

// --- Styled Components ---
const StyledPopupFrame = styled.div`
    visibility: ${({ visible }) => (visible ? 'visible' : 'hidden')};
`;

const Frame = styled.div`
    ${cssFullAbsolutePosition};
    top: ${({ isBottom }) => (isBottom ? 'auto' : 0)};
    bottom: ${({ isBottom }) => (isBottom ? 0 : 'auto')};
    z-index: ${({ zIndex }) => zIndex || 0};
`;
