import styled from 'styled-components';
import PopupFrameBackground from './PopupFrameBackground';
import { cssFullAbsolutePosition } from '../CommonStyledCSS';

const PopupFrame = ({ children, zIndex, isBottom }) => {
    return (
        <>
            <PopupFrameBackground zIndex={zIndex} />
            <StyledPopupFrame
                zIndex={zIndex}
                isBottom={isBottom}
            >
                {children}
            </StyledPopupFrame>
        </>
    );
};

export default PopupFrame;

// --- Styled Components ---
// 나중에 z-index도 context + reducer 관리해야할듯
const StyledPopupFrame = styled.div`
    ${cssFullAbsolutePosition};
    top: ${({isBottom}) => isBottom ? "auto" : 0};
    z-index: ${({ zIndex }) => zIndex || 0};
`;
