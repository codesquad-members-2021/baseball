import styled from "styled-components";
import { cssOpacityBackground } from '../CommonStyledCSS';

const PopupFrameBackground = ({zIndex}) => (<StyledPopupFrameBackground zIndex={zIndex} />);

export default PopupFrameBackground;

// --- Styled Components ---

const StyledPopupFrameBackground = styled.div`
    ${cssOpacityBackground};
    z-index: ${({zIndex}) => zIndex || 0};
`;