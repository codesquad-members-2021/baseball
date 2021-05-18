import styled from 'styled-components';
import PopupFrameBackground from './PopupFrameBackground';
import { cssFullAbsolutePosition } from '../CommonStyledCSS';

const PopupFrame = ({
    children,
    options: { zIndex = null, isBottom = false, visible = false } = {
        zIndex: null,
        isBottom: false,
        visible: false,
    },
}) => {
    return (
        <StyledPopupFrame visible={visible}>
            <PopupFrameBackground zIndex={zIndex} />
            <Frame zIndex={zIndex} isBottom={isBottom} visible={visible}>
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

    transition: all 0.5s ease-in;
    transform: ${({ visible, isBottom }) =>
        isBottom
            ? visible   // isBottom - true
                ? `translateY(0%)`
                : `translateY(100%)`
            : visible   // isBottom - false
                ? `translateY(0%)`
                : `translateY(-100%)`};
`;
